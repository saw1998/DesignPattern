package Structural.Decorator;

/*
 * We have plain text, and we want to add features like bold, italic, underline dynamically.
 */

/*
 * Component
 */
interface Text{
    String format();
}

/*
 * Concrete Component
 */
class PlainText implements Text{
    private String content;

    public PlainText(String content){
        this.content = content;
    }

    @Override
    public String format(){
        return content;
    }
}

/*
 * Decorator
 */
abstract class TextDecorator implements Text{
    protected Text decoratedText;
    
    public TextDecorator(Text text){
        this.decoratedText = text;
    }

    @Override
    public String format(){
        return decoratedText.format();
    }
}

/*
 * Concrete decorator
 */
class BoldDecorator extends TextDecorator{
    public BoldDecorator(Text text){
        super(text);
    }

    @Override
    public String format(){
        return "<b>" + super.format() + "</b>";
    }
}

class ItalicDecorator extends TextDecorator{
    public ItalicDecorator(Text text){
        super(text);
    }

    @Override
    public String format(){
        return "<i>" + super.format() + "</i>";
    }
}

class UnderlineDecorator extends TextDecorator{
    public UnderlineDecorator(Text text){
        super(text);
    }

    @Override
    public String format(){
        return "<u>" + super.format() + "</u>";
    }
}


/*
 * Client
 */

public class TextEditorDemo {
    public static void main(String[] args){
        Text text = new PlainText("Hello world");

        //Add bold
        text = new BoldDecorator(text);

        //Add italic
        text = new ItalicDecorator(text);

        //add underline
        text = new UnderlineDecorator(text);

        System.out.println(text.format());
    }
}
