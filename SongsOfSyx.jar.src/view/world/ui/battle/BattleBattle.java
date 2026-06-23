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
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class BattleBattle extends Battle {
/*  19 */   public static CharSequence ¤¤RetreatCant = "¤Your forces are trapped, they can't retreat.";
/*  20 */   private static CharSequence ¤¤RetreatD = "¤Make a tactical retreat. Your allies will not engage, but your commanding force will move out of harms way. In doing so you will lose {0} men and some equipment in the process.";
/*  21 */   private static CharSequence ¤¤desc = "Our mighty forces are about to engage an enemy host. What are your orders?";
/*     */   
/*  23 */   private static CharSequence ¤¤commandDD = "¤Take personal command and fight this battle on the field. The outcome will depend on your skill of leading men into battle. Your allies might resent you if you waste their men.";
/*     */ 
/*     */   
/*  26 */   private static CharSequence ¤¤Retreat = "¤Retreat";
/*     */   static {
/*  28 */     D.ts(BattleBattle.class);
/*     */   }
/*     */   
/*     */   private final ACTION close;
/*     */   
/*     */   BattleBattle(ACTION close) {
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
/*  47 */           BattleBattle.this.close.exe();
/*  48 */           BattleBattle.this.g.engage();
/*     */         }
/*     */       };
/*  51 */     bb.hoverInfoSet(¤¤commandDD);
/*  52 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/*  54 */     bb = new Battle.Butt((SPRITE)(UI.icons()).s.cog, ¤¤AutoResolve)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  57 */           Text t = text.text();
/*  58 */           t.add(BattleBattle.¤¤autoD);
/*  59 */           t.insert(0, BattleBattle.this.g.victory ? Dic.¤¤Victory : (
/*  60 */               (BattleBattle.this.g.player.losses() >= BattleBattle.this.g.player.men()) ? BattleBattle.¤¤Annihilation : Dic.¤¤Defeat));
/*  61 */           t.insert(1, BattleBattle.this.g.player.losses());
/*  62 */           t.insert(2, BattleBattle.this.g.enemy.losses());
/*  63 */           text.add((SPRITE)t);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  69 */           super.render(r, ds, isActive, isSelected, isHovered);
/*  70 */           if (BattleBattle.this.g.victory) {
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
/*  81 */             BattleBattle.this.setCas(false, true);
/*  82 */             return true;
/*     */           } 
/*  84 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  89 */           BattleBattle.this.close.exe();
/*  90 */           BattleBattle.this.g.auto();
/*     */         }
/*     */       };
/*  93 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/*  95 */     bb = new Battle.Butt((SPRITE)(UI.icons()).s.arrow_left, ¤¤Retreat)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/*  99 */           if (BattleBattle.this.g.player.lossesRetreat() >= BattleBattle.this.g.player.men()) {
/* 100 */             text.text(BattleBattle.¤¤RetreatCant);
/*     */           } else {
/* 102 */             Text t = text.text();
/* 103 */             t.add(BattleBattle.¤¤RetreatD);
/* 104 */             t.insert(0, BattleBattle.this.g.player.lossesRetreat());
/* 105 */             text.add((SPRITE)t);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 113 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 114 */           if (BattleBattle.this.g.player.lossesRetreat() >= BattleBattle.this.g.player.men()) {
/* 115 */             OPACITY.O25.bind();
/* 116 */             COLOR.RED100.render(r, (RECTANGLE)this.body, -4);
/* 117 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 123 */           if (BattleBattle.this.g.player.lossesRetreat() >= BattleBattle.this.g.player.men()) {
/*     */             return;
/*     */           }
/* 126 */           BattleBattle.this.close.exe();
/* 127 */           BattleBattle.this.g.retreat();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 133 */           if (super.hover(mCoo)) {
/* 134 */             BattleBattle.this.setCas(true, false);
/* 135 */             return true;
/*     */           } 
/* 137 */           return false;
/*     */         }
/*     */       };
/* 140 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/* 142 */     return (RENDEROBJ)ss;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */