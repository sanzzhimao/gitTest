 class XiYou{
	
		private String weapon;
		private String zdl;
		private String nl;
		private String name;
		
		public String getName() {
			return name;
		}
		 public void setName(String name) {
			 this.name = name;
		 }
		 
		 public String getWeapon() {
			 return weapon;
		 }
		 public void setWeapon(String weapon) {
			 this.weapon = weapon;
		 }
		 
		 public String getZdl() {
			 return zdl;
		 }
		 public void setZdl(String zdl) {
			 this.zdl = zdl;
		 }
		 
		 public String getNl() {
			 return nl;
		 }
		 public void setNl(String nl) {
			 this.nl = nl;
		 }
		 
		 public void show1() {
			 System.out.println(getName()+" ������"+getWeapon()+"   ս������"+getZdl()+"   ������"+getNl());
		 }
}

public class XiYouJi {

	public static void main(String[] args) {
	
		XiYou sun = new XiYou();
		sun.setName("�����");
		sun.setWeapon("�𹿰�");
		sun.setZdl("�����");
		sun.setNl("�����");
		sun.show1();
		
		XiYou tang = new XiYou();
		tang.setName("��ɮ    ");
		tang.setWeapon("��          ");
		tang.setZdl("��         ");
		tang.setNl("�����");
		tang.show1();
		
		XiYou zhu = new XiYou();
		zhu.setName("��˽�");
		zhu.setWeapon("����    ");
		zhu.setZdl("�Ŀ���");
		zhu.setNl("�Ŀ���");
		zhu.show1();
		
		XiYou sha = new XiYou();
		sha.setName("ɳɮ    ");
		sha.setWeapon("������");
		sha.setZdl("������");
		sha.setNl("�Ŀ���");
		sha.show1();
	
	}
	
}
