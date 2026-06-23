/*     */ package view.world.ui.battle;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.battle.spec.WBattleSpec;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ final class BattleSally extends Battle {
/*  23 */   private static CharSequence ¤¤name = "The Sally of {0}";
/*  24 */   private static CharSequence ¤¤desc = "Our garrison is about to sally out to break the siege.";
/*  25 */   private static CharSequence ¤¤CommandD = "¤Take personal command and fight this battle on the field. The outcome will depend on your skill of leading men into battle.";
/*     */   
/*  27 */   private static CharSequence ¤¤Retire = "¤Fall Back";
/*  28 */   private static CharSequence ¤¤RetireD = "¤Abort the whole operation. No one will be harmed.";
/*     */   static {
/*  30 */     D.ts(BattleSally.class);
/*     */   }
/*     */   
/*     */   private final ACTION close;
/*     */   
/*     */   BattleSally(ACTION close) {
/*  36 */     super(¤¤desc);
/*  37 */     this.close = close;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CharSequence title(WBattleSpec g) {
/*  42 */     Region reg = (Region)(WORLD.REGIONS()).map.get(g.player.coo());
/*  43 */     Str.TMP.clear().add(¤¤name);
/*  44 */     Str.TMP.insert(0, (CharSequence)reg.info.name());
/*  45 */     return (CharSequence)Str.TMP;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected RENDEROBJ buttons() {
/*  51 */     GuiSection ss = new GuiSection();
/*     */ 
/*     */     
/*  54 */     GButt.ButtPanel bb = new Battle.Butt((SPRITE)(UI.icons()).s.sword, ¤¤Command)
/*     */       {
/*     */         protected void clickA() {
/*  57 */           BattleSally.this.close.exe();
/*  58 */           BattleSally.this.g.engage();
/*     */         }
/*     */       };
/*  61 */     bb.hoverInfoSet(¤¤CommandD);
/*  62 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/*  64 */     bb = new Battle.Butt((SPRITE)(UI.icons()).s.cog, ¤¤AutoResolve)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  67 */           Text t = text.text();
/*  68 */           t.add(BattleSally.¤¤autoD);
/*  69 */           t.insert(0, BattleSally.this.g.victory ? Dic.¤¤Victory : (
/*  70 */               (BattleSally.this.g.player.losses() >= BattleSally.this.g.player.men()) ? BattleSally.¤¤Annihilation : Dic.¤¤Defeat));
/*  71 */           t.insert(1, BattleSally.this.g.player.losses());
/*  72 */           t.insert(2, BattleSally.this.g.enemy.losses());
/*  73 */           text.add((SPRITE)t);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  79 */           super.render(r, ds, isActive, isSelected, isHovered);
/*  80 */           if (BattleSally.this.g.victory) {
/*  81 */             OPACITY.O25.bind();
/*  82 */             COLOR.ORANGE100.render(r, (RECTANGLE)this.body, -4);
/*  83 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/*  90 */           if (super.hover(mCoo)) {
/*  91 */             BattleSally.this.setCas(false, true);
/*  92 */             return true;
/*     */           } 
/*  94 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  99 */           BattleSally.this.close.exe();
/* 100 */           BattleSally.this.g.auto();
/*     */         }
/*     */       };
/* 103 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/* 105 */     bb = new Battle.Butt((SPRITE)(UI.icons()).s.arrow_left, ¤¤Retire)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 109 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 110 */           if (BattleSally.this.g.player.lossesRetreat() >= BattleSally.this.g.player.men()) {
/* 111 */             OPACITY.O25.bind();
/* 112 */             COLOR.RED100.render(r, (RECTANGLE)this.body, -4);
/* 113 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 119 */           if (BattleSally.this.g.player.lossesRetreat() >= BattleSally.this.g.player.men()) {
/*     */             return;
/*     */           }
/* 122 */           BattleSally.this.close.exe();
/* 123 */           BattleSally.this.g.retreat();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 129 */           if (super.hover(mCoo)) {
/* 130 */             BattleSally.this.setCas(true, false);
/* 131 */             return true;
/*     */           } 
/* 133 */           return false;
/*     */         }
/*     */       };
/* 136 */     bb.hoverInfoSet(¤¤RetireD);
/* 137 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/* 139 */     return (RENDEROBJ)ss;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleSally.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */