/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import settlement.stats.colls.StatsTraits;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
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
/*    */ 
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 63 */     GFORMAT.perc(text, p.getD(c, (Race)race.get()));
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 68 */     b.title(p.trait.info.name);
/* 69 */     b.text(p.trait.info.desc);
/* 70 */     b.NL();
/* 71 */     b.add((SPRITE)GFORMAT.i(b.text(), p.get(c, (Race)race.get())));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\MenuProp$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */