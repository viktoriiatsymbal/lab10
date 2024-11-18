package lab10.decorator;


public class CachedDocument implements Document{
    private Document document;

    @Override
    public String parse() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'parse'");
        String cached = DBConnection.getInstance().getDocument(getGcsPath());
        if (cached != null) {
            return cached;
        } else {
            String parsed = document.parse();
            DBConnection.getInstance().createDocument(getGcsPath(), parsed);
            return parsed;
        }
    }


    public String getGcsPath() {
        return document.getGcsPath();
    }

    
}
