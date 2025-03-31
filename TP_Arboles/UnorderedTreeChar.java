import java.util.ArrayList;

public class UnorderedTreeChar extends UnorderedTree<Character> {
  public ArrayList<String> getWords(int vowelsCount){

    ArrayList<String> res = new ArrayList<String>();

    getWords(root, vowelsCount, "", res);


    return res;

  }

  private void getWords(TreeNode<Character> actual, int vowelsCount, String currentWord, ArrayList<String> result){


    if (actual == null) {
      return;
    }

    currentWord += actual.getValue();

    int isVowel = 0;
    if (isVowel(actual.getValue())) {
      isVowel = 1;
    }

    vowelsCount -= isVowel;

    if (actual.getLeft() == null && actual.getRight() == null) {
      if (vowelsCount == 0) {
        result.add(currentWord);
      }
    }

    getWords(actual.getLeft(), vowelsCount, currentWord, result);
    getWords(actual.getRight(), vowelsCount, currentWord, result);



  }

  private boolean isVowel(Character c){
    return c.equals('A') || c.equals('E') ||c.equals('I') ||c.equals('O') ||c.equals('U');
  }
}
