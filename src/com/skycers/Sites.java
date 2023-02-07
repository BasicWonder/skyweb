package com.skycers;
enum Sites{
   GOOGLE,
   YOUTUBE,
   YAHOO;
   
   
      public boolean match(String compareTo) {
        String[] similar= this.similar();
        for(int i = 0; i < similar.length; i++){
            if(similar[i].equals(compareTo)){
                
                System.out.println("Result URL: " + this.url());
                
                return true;
            
            }
        }
        return false;
      }
      public String[] similar() {
            switch(this){
                case GOOGLE: 
                    return new String[] {"goog","google","gog","goo.gl","goggle","gogle"};
                case YOUTUBE: 
                    return new String[] {"yt","youtube","you","yatube","yotube","youtub","you tube"};
                case YAHOO: 
                    return new String[] {"yah","yahoo","yaho","yhoo","yaooh"};
                default: 
                    return null;
            }
            
            
      }
      public String url() {
            switch(this){
                case GOOGLE: 
                    return "https://google.com";
                case YOUTUBE: 
                    return "https://youtube.com";
                case YAHOO: 
                    return "https://yahoo.com";
                default: 
                    return null;
            }
            
            
      }
}
