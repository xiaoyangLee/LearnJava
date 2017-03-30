package com.lxy.experiment11;

import java.util.*;
import java.awt.*;
import javax.swing.*;

class CardBuffer {
	private int value;
	private boolean isEmpty = true;
	private int i = (int) (Math.random() * 4 + 1);
	private int order = i;
	private int number;

	CardBuffer(int number) {
		this.number = number;
	}

	synchronized void put(int i) {

		while (!this.isEmpty)
			try {
				this.wait();
			} catch (InterruptedException ex) {
			}

		this.value = i;
		this.isEmpty = false;
		this.notifyAll();
	}

	synchronized int get(int order) {
		while(this.isEmpty)
		//while (this.isEmpty || (this.order != order))

			try {
				this.wait();
			} catch (InterruptedException ex) {
			}

		this.isEmpty = true;
		this.notifyAll();
		this.order = (this.order + 1) % this.number;
		return this.value;
	}
}

class SendCardThread extends Thread {
	private CardBuffer cardbuffer;
	private int cardMax;
	private int number;

	public SendCardThread(CardBuffer cardbuffer, int cardMax, int number) {
		this.cardbuffer = cardbuffer;
		this.cardMax = cardMax;
		this.number = number;
		this.setPriority(Thread.MAX_PRIORITY);
	}

	public void run() {
		for (int i = 1; i <= this.cardMax; i++)
			this.cardbuffer.put(i);
		for (int i = 1; i <= this.number; i++)
			this.cardbuffer.put(-1);
	}
}

class ReceiveCardJFrame extends JFrame implements Runnable {
	private CardBuffer cardbuffer;
	private JTextArea text;
	private int order;

	public ReceiveCardJFrame(CardBuffer cardbuffer, int order, String title, int x, int y) {
		super(title);
		this.setBounds(x, y, 290, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.cardbuffer = cardbuffer;
		this.order = order;

		this.text = new JTextArea();
		this.getContentPane().add(this.text);
		this.text.setLineWrap(true);
		this.text.setEditable(false);
		this.text.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setVisible(true);
		new Thread(this).start();
	}

	public void run() {
		while (true) {
			int value = this.cardbuffer.get(this.order);
			if (value == -1)
				break;
			this.text.append(String.format("%4d", value));
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
		}
		System.out.println(this.getClass().getName() + " " + this.order + "结束。");

	}
}

public class DealCard // 发牌程序
{
	public DealCard(int cardMax, int number) // cardMax指定最大牌值，number指定人数
	{
		CardBuffer cardbuf = new CardBuffer(number);
		new SendCardThread(cardbuf, cardMax, number).start();
		String titles[] = { "北", "东", "南", "西" };
		int x[] = { 400, 700, 400, 100 }, y[] = { 200, 320, 440, 320 };
		for (int i = 0; i < number; i++)
			new ReceiveCardJFrame(cardbuf, i, titles[i], x[i], y[i]);
	}

	public static void main(String arg[]) {
		//new DealCard(52, 4);// 4个玩家，52张牌
		new DealCard(52, 3);
	}
}

// 发送1~52间的随机数列
class SendCardThread2 extends Thread {
	private CardBuffer cardbuffer;
	private java.util.ArrayList<Integer> list;
	private int number;

	public SendCardThread2(CardBuffer cardbuffer, int cardMax, int number) {
		this.cardbuffer = cardbuffer;
		this.number = number;
		this.list = new ArrayList<Integer>();
		for (int i = 1; i <= cardMax; i++)
			list.add(new Integer(i));

		java.util.Collections.shuffle(list);
	}

	public void run() {
		Iterator<Integer> it = this.list.iterator();
		while (it.hasNext())
			this.cardbuffer.put((Integer) it.next());
		for (int i = 1; i <= this.number; i++)
			this.cardbuffer.put(-1);
	}
}
