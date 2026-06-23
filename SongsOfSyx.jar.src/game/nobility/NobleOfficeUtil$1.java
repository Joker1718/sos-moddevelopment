/*    */ package game.nobility;
/*    */ 
/*    */ import game.boosting.Boostable;
/*    */ import init.sprite.UI.Icon;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends NobleOffice
/*    */ {
/*    */   null(ArrayListGrower<NobleOffice> $anonymous0, double $anonymous1, Boostable $anonymous2, CharSequence $anonymous3, CharSequence $anonymous4, Icon $anonymous5) {
/* 59 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*    */   }
/*    */   
/*    */   public double value(int slots) {
/* 63 */     return slots / 1000.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean leavesMap() {
/* 69 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverValue(GBox b, int slots) {
/* 75 */     b.add((SPRITE)this.target.icon);
/* 76 */     b.textLL(this.target.name);
/* 77 */     b.tab(6);
/* 78 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (slots * gov)));
/* 79 */     b.NL();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int popBoosted(int slots) {
/* 86 */     return -1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\NobleOfficeUtil$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */