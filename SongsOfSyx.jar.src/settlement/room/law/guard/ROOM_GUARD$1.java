/*     */ package settlement.room.law.guard;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements BOOLEANO.BOOLEAN_OE<Div>
/*     */ {
/* 114 */   private final INFO info = new INFO(ROOM_GUARD.¤¤guard, ROOM_GUARD.¤¤guardD);
/*     */ 
/*     */   
/*     */   public boolean is(Div t) {
/* 118 */     return ROOM_GUARD.this.guardMode.get(t.indexArmy());
/*     */   }
/*     */ 
/*     */   
/*     */   public BOOLEANO.BOOLEAN_OE<Div> set(Div t, boolean b) {
/* 123 */     ROOM_GUARD.this.guardMode.set(t.indexArmy(), b);
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/* 129 */     return this.info;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\ROOM_GUARD$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */