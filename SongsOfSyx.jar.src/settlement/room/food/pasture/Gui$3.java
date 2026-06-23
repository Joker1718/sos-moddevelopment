/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import util.data.GETTER;
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
/* 102 */     GFORMAT.perc(text, ((PastureInstance)getter.get()).skill());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 108 */     b.title(Gui.¤¤Skill);
/* 109 */     b.text(Gui.¤¤SkillD);
/* 110 */     b.NL(8);
/* 111 */     IndustryUtil.hoverBoosts((GUI_BOX)b, 1.0D, null, ((Industry)(((PastureInstance)getter.get()).blueprintI()).indus.get(0)).bonus(), (RoomInstance)getter.get(), 1.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\Gui$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */