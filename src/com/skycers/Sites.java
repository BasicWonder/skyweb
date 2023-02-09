package com.skycers;
enum Sites{
   GOOGLE,
   YOUTUBE,
   YAHOO,
   DISCORD,
   INSTAGRAM,
   TWITTER,
   EBAY,
   QUORA;

   
   
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
                case DISCORD: 
                    return new String[] {"discord","discor","disco","dis"};
                case TWITTER: 
                    return new String[] {"twitt","twitter","tweet"};
                case INSTAGRAM: 
                    return new String[] {"insta","instagram","gram","instagra"};
                case EBAY: 
                    return new String[] {"ebay","e-bay","eba","elay"};
                case QUORA: 
                    return new String[] {"quora","quroa","quo","qur"};
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
                case DISCORD: 
                    return "https://discord.com";
                case TWITTER: 
                    return "https://twitter.com";
                case INSTAGRAM: 
                    return "https://instagram.com";
                case EBAY: 
                    return "https://ebay.com";
                case QUORA: 
                    return "https://quora.com";
                default: 
                    return null;
            }
            
            
      }
}
