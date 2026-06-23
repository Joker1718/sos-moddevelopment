/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
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
/*     */ class Row
/*     */   extends GuiSection
/*     */ {
/*     */   private final Boostable bo;
/*     */   
/*     */   Row(final Boostable bo) {
/*  89 */     this.bo = bo;
/*     */     
/*  91 */     add((SPRITE)bo.icon, 0, 0);
/*  92 */     addRightC(2, (SPRITE)new GText((UI.FONT()).M, bo.name));
/*  93 */     addRightCAbs(250, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  97 */             GFORMAT.f(text, bo.get((BOOSTABLE_O)HCLASS_RACE.clP((Race)(MenuProp.Row.access$0(MenuProp.Row.this)).race.get(), (MenuProp.Row.access$0(MenuProp.Row.this)).c)));
/*     */           }
/*     */         });
/* 100 */     body().incrW(64.0D);
/* 101 */     pad(2, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 106 */     if (hoveredIs())
/* 107 */       COLOR.WHITE15.render(r, (RECTANGLE)body()); 
/* 108 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 113 */     GBox b = (GBox)text;
/* 114 */     b.title(this.bo.name);
/* 115 */     b.text(this.bo.desc);
/* 116 */     b.NL(8);
/*     */     
/* 118 */     this.bo.hover((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP((Race)MenuProp.this.race.get(), MenuProp.this.c), true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\MenuProp$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */