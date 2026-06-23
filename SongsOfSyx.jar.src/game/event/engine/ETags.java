/*    */ package game.event.engine;
/*    */ 
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ 
/*    */ final class ETags
/*    */ {
/*    */   public final String[] adds;
/*    */   public final String[] removes;
/*    */   public final String[] allows;
/*    */   public final String[] allows_not;
/*    */   
/*    */   ETags(Json d) {
/* 14 */     if (d.has("TAGS")) {
/* 15 */       d = d.json("TAGS");
/* 16 */       this.adds = read(d, "ADD");
/* 17 */       this.removes = read(d, "REMOVE");
/* 18 */       this.allows = read(d, "ALLOW");
/* 19 */       this.allows_not = read(d, "ALLOW_NOT");
/* 20 */       d.checkUnused();
/*    */     } else {
/* 22 */       this.adds = new String[0];
/* 23 */       this.removes = this.adds;
/* 24 */       this.allows = this.adds;
/* 25 */       this.allows_not = this.adds;
/*    */     } 
/*    */   }
/*    */   
/*    */   private String[] read(Json d, String key) {
/* 30 */     if (d.has(key)) {
/* 31 */       return d.values(key);
/*    */     }
/* 33 */     return new String[0]; } public boolean can(KeyMap<Boolean> tags) {
/*    */     byte b;
/*    */     int i;
/*    */     String[] arrayOfString;
/* 37 */     for (i = (arrayOfString = this.allows).length, b = 0; b < i; ) { String k = arrayOfString[b];
/* 38 */       if (!tags.containsKey(k) || tags.get(k) == Boolean.FALSE)
/* 39 */         return false; 
/*    */       b++; }
/*    */     
/* 42 */     for (i = (arrayOfString = this.allows_not).length, b = 0; b < i; ) { String k = arrayOfString[b];
/* 43 */       if (tags.containsKey(k) && tags.get(k) == Boolean.TRUE)
/* 44 */         return false;  b++; }
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\ETags.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */