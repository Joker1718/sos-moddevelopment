/*     */ package view.world.ui.battle;
/*     */ 
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
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class BattleAssist extends Battle {
/*  20 */   private static CharSequence ¤¤desc = "Our allies are about to engage an enemy host. Do we help them, or do we stand idly by and watch?";
/*  21 */   private static CharSequence ¤¤CommandD = "¤Take personal command and fight this battle on the field. The outcome will depend on your skill of leading men into battle. Your allies might resent you if you waste their men.";
/*  22 */   private static CharSequence ¤¤Assist = "¤Assist";
/*  23 */   private static CharSequence ¤¤assistD = "¤Partake in this battle but let your allies command it. The result will be {0}. You will lose about {1} men and inflict about {2} casualties on the enemy.";
/*  24 */   private static CharSequence ¤¤Annihilation = "¤your annihilation";
/*  25 */   private static CharSequence ¤¤Decline = "¤Decline";
/*  26 */   private static CharSequence ¤¤DeclineD = "¤Decline to partake in this conflict and spare your men and the enemy at the expense of your allies.";
/*     */   static {
/*  28 */     D.ts(BattleAssist.class);
/*     */   }
/*     */   
/*     */   private final ACTION close;
/*     */   
/*     */   BattleAssist(ACTION close) {
/*  34 */     super(¤¤desc);
/*  35 */     this.close = close;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected RENDEROBJ buttons() {
/*  41 */     GuiSection ss = new GuiSection();
/*     */ 
/*     */     
/*  44 */     GButt.ButtPanel bb = new Battle.Butt((SPRITE)(UI.icons()).s.sword, ¤¤Command)
/*     */       {
/*     */         protected void clickA() {
/*  47 */           BattleAssist.this.close.exe();
/*  48 */           BattleAssist.this.g.engage();
/*     */         }
/*     */       };
/*  51 */     bb.hoverInfoSet(¤¤CommandD);
/*  52 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/*  54 */     bb = new Battle.Butt((SPRITE)(UI.icons()).s.cog, ¤¤Assist)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  57 */           Text t = text.text();
/*  58 */           t.add(BattleAssist.¤¤assistD);
/*  59 */           t.insert(0, BattleAssist.this.g.victory ? Dic.¤¤Victory : (
/*  60 */               (BattleAssist.this.g.player.losses() >= BattleAssist.this.g.player.men()) ? BattleAssist.¤¤Annihilation : Dic.¤¤Defeat));
/*  61 */           t.insert(1, BattleAssist.this.g.player.losses());
/*  62 */           t.insert(2, BattleAssist.this.g.enemy.losses());
/*  63 */           text.add((SPRITE)t);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  69 */           super.render(r, ds, isActive, isSelected, isHovered);
/*  70 */           if (BattleAssist.this.g.victory) {
/*  71 */             OPACITY.O25.bind();
/*  72 */             COLOR.ORANGE100.render(r, (RECTANGLE)this.body, -4);
/*  73 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/*  80 */           if (super.hover(mCoo)) {
/*  81 */             BattleAssist.this.setCas(false, true);
/*  82 */             return true;
/*     */           } 
/*  84 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  89 */           BattleAssist.this.close.exe();
/*  90 */           BattleAssist.this.g.auto();
/*     */         }
/*     */       };
/*  93 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/*  95 */     bb = new Battle.Butt((SPRITE)(UI.icons()).s.arrow_left, ¤¤Decline)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/*  99 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 100 */           if (BattleAssist.this.g.player.lossesRetreat() >= BattleAssist.this.g.player.men()) {
/* 101 */             OPACITY.O25.bind();
/* 102 */             COLOR.RED100.render(r, (RECTANGLE)this.body, -4);
/* 103 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 109 */           if (BattleAssist.this.g.player.lossesRetreat() >= BattleAssist.this.g.player.men()) {
/*     */             return;
/*     */           }
/* 112 */           BattleAssist.this.close.exe();
/* 113 */           BattleAssist.this.g.retreat();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 119 */           if (super.hover(mCoo)) {
/* 120 */             BattleAssist.this.setCas(true, false);
/* 121 */             return true;
/*     */           } 
/* 123 */           return false;
/*     */         }
/*     */       };
/* 126 */     bb.hoverInfoSet(¤¤DeclineD);
/* 127 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/* 129 */     return (RENDEROBJ)ss;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleAssist.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */