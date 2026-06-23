/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoosterAbs;
/*     */ import init.race.Race;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(int $anonymous0, int $anonymous1) {
/*  83 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  87 */     GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/*  88 */     ss.boostable.icon.renderCY(r, body().x1() + 8, body().cY());
/*  89 */     t.clear();
/*  90 */     GFORMAT.f0(t, ss.inc((BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl)));
/*  91 */     t.renderCY(r, body().x1() + 28, body().cY());
/*  92 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX box) {
/*  96 */     GBox bb = (GBox)box;
/*     */ 
/*     */     
/*  99 */     bb.title(ss.tName);
/* 100 */     double d = 0.0D;
/* 101 */     for (Religion rr : RELIGIONS.ALL()) {
/* 102 */       for (BoostSpec sb : rr.boosts.all()) {
/* 103 */         if (sb.boostable == ss.boostable) {
/* 104 */           sb.booster.hover(box, sb.booster.get(HCLASS_RACE.clP((Race)race.get(), cl)));
/* 105 */           BoosterAbs.hoverSpan((GUI_BOX)bb, sb.booster.from(), sb.booster.to());
/* 106 */           bb.NL();
/*     */         } 
/*     */       } 
/*     */     } 
/* 110 */     bb.NL(8);
/*     */     
/* 112 */     bb.textLL(Dic.¤¤Boosts);
/* 113 */     bb.tab(7);
/* 114 */     bb.add((SPRITE)GFORMAT.f0(bb.text(), d));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatReligion$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */