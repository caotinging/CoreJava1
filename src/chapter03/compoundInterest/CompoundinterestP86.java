package chapter03.compoundInterest;

/*
 * ʱ��:2017.3.13
 * һά����interest���ڴ洢����
 * ��ά����balancesһά��ʾ���ά��ʾ����
 * */

public class CompoundinterestP86 {
public static void main(String[] args){
	final double STARTRATE = 10;
	final int NRATES = 6;
	final int NYEARS = 10;
	//final�����ǳ��� ������ֵ�����ٸı�
	double[] interestRate = new double[NRATES];
	for(int j = 0;j < interestRate.length;j++)
		interestRate[j] = (STARTRATE + j)/100;
	//���ʴ�10%��15%
	double[][] balances = new double[NYEARS][NRATES];
	//����һ����ά����
	for(int j = 0;j < balances[0].length;j++)
		balances[0][j] = 10000;
	//�ó�ʼ����ʼ���ö�ά����ĵ�һ��
	for(int i = 1;i < balances.length;i++)
		for(int j = 0;j < balances[i].length;j++){
			double Oldbalances = balances[i-1][j];//ÿ����µı���
			double interest = Oldbalances*interestRate[j];//�������Ϣ
			balances[i][j] = Oldbalances + interest;//��Ϣ��
			//System.out.println("i��ֵ:"+i);
		}
	for(int j = 0;j < interestRate.length;j++)
		System.out.printf("%9.0f%%",100 * interestRate[j]);
	System.out.println();
	for(double[] row:balances){
		for(double b:row)
			System.out.printf("%10.2f",b);
		System.out.println();
	}
}
}
