/*    */ package init.value;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public class Values<T>
/*    */ {
/* 12 */   private final ArrayListGrower<Value<T>> all = new ArrayListGrower();
/*    */   private final GValueCat<T> mommy;
/*    */   
/*    */   Values(GValueCat<T> mommy) {
/* 16 */     this.mommy = mommy;
/*    */   }
/*    */   
/*    */   public void push(String targetKey, Object path) {
/* 20 */     this.mommy.inits.add(new Promise(targetKey, path.toString()));
/*    */   }
/*    */   
/*    */   public void push(Json json, String... notallowed) {
/* 24 */     push("VALUE", json, notallowed);
/*    */   }
/*    */ 
/*    */   
/*    */   public void push(String key, Json json, String... notallowed) {
/* 29 */     if (!json.has(key)) {
/*    */       return;
/*    */     }
/* 32 */     String path = json.path() + ", line" + json.path(); byte b; int i;
/*    */     String[] arrayOfString;
/* 34 */     for (i = (arrayOfString = json.values(key)).length, b = 0; b < i; ) { String k = arrayOfString[b];
/* 35 */       push(k, path);
/*    */       b++; }
/*    */   
/*    */   }
/*    */   
/*    */   public void pushJson(String key, Json json, String... notallowed) {
/* 41 */     if (!json.has(key)) {
/*    */       return;
/*    */     }
/* 44 */     String path = json.path() + ", line" + json.path(); byte b; int i;
/*    */     String[] arrayOfString;
/* 46 */     for (i = (arrayOfString = json.values(key)).length, b = 0; b < i; ) { String k = arrayOfString[b];
/* 47 */       push(k, path);
/*    */       b++; }
/*    */   
/*    */   }
/*    */   public LIST<Value<T>> all() {
/* 52 */     return (LIST<Value<T>>)this.all;
/*    */   }
/*    */   
/*    */   private class Promise
/*    */     implements ACTION {
/*    */     public final String key;
/*    */     public final String path;
/*    */     
/*    */     Promise(String key, String path) {
/* 61 */       this.key = key;
/* 62 */       this.path = path;
/*    */     }
/*    */ 
/*    */     
/*    */     public void exe() {
/* 67 */       if (Values.this.mommy.get(this.key) == null) {
/* 68 */         if (!Values.this.mommy.hasSpewed) {
/* 69 */           GAME.Warn(this.path + this.path + "no value named : " + System.lineSeparator() + " available: " + this.key + System.lineSeparator());
/*    */         } else {
/* 71 */           LOG.ln("no value: " + this.key + "path: " + this.path);
/*    */         } 
/* 73 */         Values.this.mommy.hasSpewed = true;
/*    */       } else {
/*    */         
/* 76 */         Values.this.all.add(Values.this.mommy.get(this.key));
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Values.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */