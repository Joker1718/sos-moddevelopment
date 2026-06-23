/*     */ package settlement.room.knowledge.school;
/*     */ 
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
/* 111 */     GFORMAT.f0(text, RoomEducationHelper.null.access$0(RoomEducationHelper.null.this).learningSpeed((RoomInstance)get.get()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 116 */     b.title((RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).bonus.name);
/* 117 */     b.text((RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).bonus.desc);
/* 118 */     b.NL();
/*     */     
/* 120 */     IndustryUtil.hoverProductionRate((GUI_BOX)b, 1.0D, (RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).rate, (RoomInstance)get.get());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\RoomEducationHelper$3$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */