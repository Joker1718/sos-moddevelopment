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
/*     */ import world.WORLD;
/*     */ import world.battle.spec.WBattleSpec;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ final class BattleLastStand extends Battle {
/*  22 */   private static CharSequence ¤¤name = "The Last Stand of {0}";
/*  23 */   private static CharSequence ¤¤desc = "The enemy is about to take the city! Some of the defenders implore you to lead them in a sally, either to disperse the besiegers or to die with honour.";
/*  24 */   private static CharSequence ¤¤CommandD = "¤Take personal command and fight this battle on the field. The outcome will depend on your skill of leading men into battle.";
/*     */   
/*  26 */   private static CharSequence ¤¤Retire = "¤Decline";
/*  27 */   private static CharSequence ¤¤RetireD = "¤Let the garrison fend for themselves and die in the defence of the city.";
/*     */   static {
/*  29 */     D.ts(BattleLastStand.class);
/*     */   }
/*     */   
/*     */   private final ACTION close;
/*     */   
/*     */   BattleLastStand(ACTION close) {
/*  35 */     super(¤¤desc);
/*  36 */     this.close = close;
/*     */   }
/*     */ 
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
/*  57 */           BattleLastStand.this.close.exe();
/*  58 */           BattleLastStand.this.g.engage();
/*     */         }
/*     */       };
/*  61 */     bb.hoverInfoSet(¤¤CommandD);
/*  62 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/*  64 */     bb = new Battle.Butt((SPRITE)(UI.icons()).s.cog, ¤¤Retire)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  67 */           Text t = text.text();
/*  68 */           t.add(BattleLastStand.¤¤RetireD);
/*  69 */           text.add((SPRITE)t);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  75 */           super.render(r, ds, isActive, isSelected, isHovered);
/*  76 */           if (BattleLastStand.this.g.victory) {
/*  77 */             OPACITY.O25.bind();
/*  78 */             COLOR.ORANGE100.render(r, (RECTANGLE)this.body, -4);
/*  79 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/*  86 */           if (super.hover(mCoo)) {
/*  87 */             BattleLastStand.this.setCas(false, true);
/*  88 */             return true;
/*     */           } 
/*  90 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  95 */           BattleLastStand.this.close.exe();
/*  96 */           BattleLastStand.this.g.auto();
/*     */         }
/*     */       };
/*  99 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */ 
/*     */     
/* 102 */     return (RENDEROBJ)ss;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleLastStand.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */