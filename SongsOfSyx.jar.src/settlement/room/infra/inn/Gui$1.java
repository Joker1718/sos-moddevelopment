/*    */ package settlement.room.infra.inn;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.DicTime;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 54 */     GFORMAT.iIncr(text, ((InnInstance)g.get()).earnings);
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 58 */     GText t = b.text();
/* 59 */     DicTime.setYears((Str)t, -1.0D);
/* 60 */     b.add((SPRITE)t);
/* 61 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), ((InnInstance)g.get()).earningsLast));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */