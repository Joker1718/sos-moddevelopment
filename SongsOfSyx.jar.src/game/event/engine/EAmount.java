/*    */ package game.event.engine;
/*    */ 
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ class EAmount
/*    */ {
/*  7 */   public double rel = 0.0D;
/*  8 */   public double perPerson = 0.0D;
/*  9 */   public double abs = 0.0D;
/*    */   
/*    */   EAmount(int am) {
/* 12 */     this.abs = am;
/*    */   }
/*    */   
/*    */   EAmount(Json json, int min) {
/* 16 */     this.rel = json.dTry("RELATIVE", min, 1000.0D, 0.0D);
/* 17 */     this.perPerson = json.dTry("PER_PERSON", min, 1000.0D, 0.0D);
/* 18 */     this.abs = json.dTry("AMOUNT", min, 2.147483647E9D, 0.0D);
/* 19 */     json.checkUnused();
/*    */   }
/*    */   
/*    */   public int am(double perPerson, double rel) {
/* 23 */     double am = this.abs;
/* 24 */     am += perPerson * this.perPerson;
/* 25 */     am += rel * this.rel;
/* 26 */     return (int)Math.ceil(am);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EAmount.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */