/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.ai.types.parent.AIModule_Parent;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private final GText t;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1) {
/*  90 */     super($anonymous0, $anonymous1);
/*  91 */     this.t = new GText((UI.FONT()).M, 4);
/*     */   }
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  94 */     if (a.a.indu().hType() == HTYPES.PARENT() || a.a.indu().hType() == HTYPES.PARENT_SLAVE()) {
/*  95 */       this.t.clear().add(((a.a.race()).physics.babyDays - AIModule_Parent.daysOld(a.a)));
/*  96 */       this.t.renderCY(r, body().x1(), body().cY());
/*  97 */       (UI.icons()).m.baby.render(r, body().x1() + 24, body().y1());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 103 */     if (a.a.indu().hType() == HTYPES.PARENT() || a.a.indu().hType() == HTYPES.PARENT_SLAVE()) {
/* 104 */       GBox b = (GBox)text;
/* 105 */       GText t = b.text();
/* 106 */       t.add(UISubjectEquip.¤¤infant);
/* 107 */       t.insert(0, (a.a.race()).physics.babyDays - AIModule_Parent.daysOld(a.a));
/* 108 */       b.add((SPRITE)t);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectEquip$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */