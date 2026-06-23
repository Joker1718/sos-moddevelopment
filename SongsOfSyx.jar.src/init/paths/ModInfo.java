/*    */ package init.paths;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ModInfo
/*    */ {
/*    */   public final String absolutePath;
/*    */   public final String path;
/*    */   public final String name;
/*    */   public final String desc;
/*    */   public final String version;
/*    */   public final int majorVersion;
/*    */   public final String author;
/*    */   public final String info;
/* 19 */   int TEXTURE_CACHE_SIZE = 4096;
/*    */   
/*    */   public ModInfo(String dir) throws ModInfoException {
/* 22 */     this.path = dir;
/*    */ 
/*    */     
/*    */     try {
/* 26 */       PATH g = (PATHS.local()).MODS.getFolder(dir, ".txt");
/* 27 */       this.absolutePath = String.valueOf(g.get().toAbsolutePath());
/* 28 */       Json j = new Json(g.gets("_Info"));
/* 29 */       this.name = j.text("NAME", "???");
/* 30 */       this.desc = j.text("DESC", "???");
/* 31 */       this.version = j.text("VERSION", "???");
/* 32 */       this.majorVersion = bestVersion(dir);
/* 33 */       this.author = j.text("AUTHOR", "???");
/* 34 */       this.info = j.text("INFO", "???");
/* 35 */       this.TEXTURE_CACHE_SIZE = j.i("TEXTURE_CACHE_SIZE", 0, 16384, 4096);
/*    */     }
/* 37 */     catch (Exception e) {
/* 38 */       LOG.ln("unable to load mod: " + dir + " reason: " + e.getMessage());
/*    */       
/* 40 */       throw new ModInfoException(e);
/*    */     } 
/*    */     
/* 43 */     if (this.TEXTURE_CACHE_SIZE < 4096 || this.TEXTURE_CACHE_SIZE > 16384 || (this.TEXTURE_CACHE_SIZE & this.TEXTURE_CACHE_SIZE - 1) != 0) {
/* 44 */       throw new ModInfoException("TEXTURE_CACHE_SIZE - Invalid value: " + this.TEXTURE_CACHE_SIZE + ".  Accepted are 4096, 8192, 16384 " + String.valueOf((PATHS.local()).MODS.get(dir)));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static int bestVersion(String mod) throws ModInfoException {
/* 50 */     int best = -1; byte b; int i;
/*    */     String[] arrayOfString;
/* 52 */     for (i = (arrayOfString = (PATHS.local()).MODS.getFolder(mod).folders()).length, b = 0; b < i; ) { String ss = arrayOfString[b];
/*    */       
/* 54 */       if (ss.length() >= 2 && ss.charAt(0) == 'V') {
/* 55 */         String nr = ss.substring(1);
/*    */         try {
/* 57 */           int j = Integer.parseInt(nr);
/* 58 */           if (j == 71)
/* 59 */             return j; 
/* 60 */           if (Math.ceil((71 - j)) > best)
/* 61 */             best = j; 
/* 62 */         } catch (Exception exception) {}
/*    */       } 
/*    */       
/*    */       b++; }
/*    */ 
/*    */     
/* 68 */     if (best != -1)
/* 69 */       return best; 
/* 70 */     throw new ModInfoException("There are no version folders in mod. " + String.valueOf((PATHS.local()).MODS.getFolder(mod).get()));
/*    */   }
/*    */   
/*    */   Path getModFolder() {
/* 74 */     return (PATHS.local()).MODS.getFolder(this.path).getFolder("V" + this.majorVersion).get();
/*    */   }
/*    */ 
/*    */   
/*    */   public static class ModInfoException
/*    */     extends Exception
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */     
/*    */     public ModInfoException(Exception e) {
/* 85 */       super("unable to load mod", e);
/*    */     }
/*    */     
/*    */     public ModInfoException(String m) {
/* 89 */       super(m);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\ModInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */