/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
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
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/*  92 */     GFORMAT.iofk(text, ro.employment().employed(), ro.employment().neededWorkers());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/*  97 */     b.title(ro.tInfo.name);
/*  98 */     b.text(ro.tInfo.desc);
/*  99 */     b.NL(4);
/* 100 */     b.textLL(ro.info.names);
/* 101 */     b.add((SPRITE)GFORMAT.iofk(b.text(), ro.employment().employed(), ro.employment().neededWorkers()));
/*     */     
/* 103 */     b.NL(8);
/* 104 */     b.NL();
/*     */     
/* 106 */     ro.boosters.hover((GUI_BOX)b, 1.0D, -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Info$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */