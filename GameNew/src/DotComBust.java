import java.util.*;

class DotComBust {
	
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList <DotCom>();
	private int numOfGuesses = 0;
	
	// ����� ���������� ����
	private void setUpGame() {
	
		DotCom one = new DotCom();
		one.setName("Pets.com");
		
		DotCom two = new DotCom();
		two.setName("eToys.com");
		
		DotCom three = new DotCom();
		three.setName("pornohub.com");
		
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
		System.out.println("���� ���� - �������� ��� �����.");
		System.out.println("Pets.com, eToys.com � pornohub.com");
		System.out.println("����������� �������� �� �� ����������� ���������� �����");
		
		for (DotCom dotComToSet : dotComList) {
			
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);		
		}	
	}
	
	private void startPlaying() {
		while (!dotComList.isEmpty()) {
		String userGuess = helper.getUserInput("�������� ���� ���");
		checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		
		numOfGuesses++;
		
		String result = "����";
		
		for (DotCom dotComToTest : dotComList) {
			result = dotComToTest.checkYourself(userGuess);
			
			if (result.equals("�����")) { 
				break;
			}
			
			if (result.equals("�������")) {
				dotComList.remove(dotComToTest);
				break;
			}
		}
		
		System.out.println(result);
	}
		
	private void finishGame() {
		System.out.println("��� ����� ����� �� ���! ���� ����� ������ ������ �� �����");
		
		if (numOfGuesses <= 18) {
			System.out.println("��� ������ � ��� �����" + numOfGuesses + "�������");
			System.out.println("�� ������ ��������� �� ����, ��� ���� �������� �������");
		} else {
			System.out.println("��� ������ � ��� ����� �������." + numOfGuesses +"�������");
			System.out.println("���� ����� ������� ������ ����� ��������");	
		} 	
	}

	public static void main (String[] args) {
		
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();	
	}
	

}
