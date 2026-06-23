/*     */ package view.battle.editor;
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.ui.profile.UIFactionBanner;
/*     */ 
/*     */ class ArmyFactionButt extends GuiSection {
/*     */   private final ArmySide divs;
/*  29 */   private static CharSequence ¤¤player = "player"; private final GETTER.GETTERE<ArmySide> g;
/*  30 */   private static CharSequence ¤¤enemy = "enemy";
/*     */   
/*     */   static {
/*  33 */     D.ts(ArmyFactionButt.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArmyFactionButt(final Faction f, final ArmySide divs, GETTER.GETTERE<ArmySide> g) {
/*  39 */     if (f == FACTIONS.player()) {
/*  40 */       add((SPRITE)(new GText((UI.FONT()).H2, ¤¤player)).normalify2(), 0, 0);
/*     */     } else {
/*  42 */       add((SPRITE)(new GText((UI.FONT()).H2, ¤¤enemy)).errorify(), 0, 0);
/*     */     } 
/*     */     
/*  45 */     GInput gInput = new GInput(new StringInputSprite(24, (UI.FONT()).S)
/*     */         {
/*     */           public void renAction() {
/*  48 */             text().clear().add((CharSequence)f.name);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void change() {
/*  53 */             f.name.clear().add((CharSequence)text());
/*     */           }
/*     */         });
/*     */     
/*  57 */     addDown(4, (RENDEROBJ)gInput);
/*     */ 
/*     */     
/*  60 */     GuiSection s = new GuiSection();
/*  61 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  65 */             int m = 0;
/*  66 */             for (DIV_SPEC s : divs.divs) {
/*  67 */               if (s != null)
/*  68 */                 m += s.men(); 
/*     */             } 
/*  70 */             GFORMAT.i(text, m);
/*     */           }
/*  72 */         }).hh((SPRITE)(UI.icons()).s.human));
/*     */     
/*  74 */     s.addRightC(68, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/*  79 */             int m = 0;
/*  80 */             for (DIV_SPEC s : divs.divs) {
/*  81 */               if (s != null)
/*  82 */                 m = (int)(m + (GAME.battle()).power.get(s)); 
/*     */             } 
/*  84 */             GFORMAT.i(text, m);
/*     */           }
/*  86 */         }).hh((SPRITE)(UI.icons()).s.fist));
/*     */     
/*  88 */     addRelBody(4, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */     
/*  91 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel((f.banner()).HUGE)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  95 */           (VIEW.inters()).popup.show((RENDEROBJ)new UIFactionBanner(f), (CLICKABLE)this);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 101 */     addRelBody(8, DIR.W, (RENDEROBJ)buttPanel);
/*     */     
/* 103 */     body().pad(16, 8);
/* 104 */     this.divs = divs;
/* 105 */     this.g = g;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 111 */     GButt.ButtPanel.renderBG(r, true, (this.g.get() == this.divs), hoveredIs(), (RECTANGLE)body());
/* 112 */     super.render(r, ds);
/* 113 */     GCOLOR.UI().border().renderFrame(r, (RECTANGLE)body(), 0, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 118 */     this.g.set(this.divs);
/* 119 */     super.clickA();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\ArmyFactionButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */