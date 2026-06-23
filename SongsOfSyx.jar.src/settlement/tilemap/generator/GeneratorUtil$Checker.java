/*    */ package settlement.tilemap.generator;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.map.MAP_BOOLEANE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Checker
/*    */   extends MAP_BOOLEANE.BooleanMapE
/*    */ {
/*    */   private final short[] checks;
/* 30 */   private short sI = 0;
/*    */   
/*    */   public Checker() {
/* 33 */     super(SETT.TWIDTH, SETT.THEIGHT);
/* 34 */     this.checks = new short[SETT.THEIGHT * SETT.TWIDTH];
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_BOOLEANE set(int tile, boolean value) {
/* 39 */     this.checks[tile] = (short)(value ? this.sI : (this.sI - 1));
/* 40 */     return (MAP_BOOLEANE)this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 46 */     return (this.checks[tile] == this.sI);
/*    */   }
/*    */   
/*    */   void init() {
/* 50 */     this.sI = (short)(this.sI + 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorUtil$Checker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */