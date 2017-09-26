package chapter15.IO.demo6;

import java.util.concurrent.ThreadLocalRandom;

public class Seller implements Runnable {
	private Shop s;//��Ӧ��
	private Provide p;//����
	/*//����һ��ÿ���̶߳��е��ֲ߳̾���������ÿ���̲߳����Ķ���һ����ͬ�ı���
	private static final ThreadLocal<Goods> good =
			new ThreadLocal<Goods>() {
		protected Goods good() {
			return new Goods("",0,0);
		}
	};*/
	
	public Seller(Provide p, Shop s) {
		this.p = p;
		this.s = s;
	}

	public void run() {
		Goods goodName = getGoods();
		putGoods(goodName);
	}
	
	public Goods getGoods() {
		p.plock.lock();
		try{
			int n = ThreadLocalRandom.current().nextInt(3)+1;
			if(p.pList.get(n).count <= 0)
				return null;
			p.pList.get(n).count--;
			return p.pList.get(n);
		}finally{
			p.plock.unlock();
		}
	}
	
	public void putGoods(Goods goodName) {
		s.slock.lock();
		try{
			if(goodName == null)
				return;
			for(Goods good: s.sList) {
				if(goodName.name.equals(good.name)) {
					good.count++;
					System.out.println(Thread.currentThread().getName()+"�����"+goodName.name+"��Ʒ��");
					
					s.setsMoney(goodName.cost);
				}
			}
		}finally{
			s.slock.unlock();
		}
	}
}
