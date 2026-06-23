/*     */ package view.ui.profile;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.ui.manage.IFullView;
/*     */ 
/*     */ public final class UILevel extends IFullView {
/*     */   private final CLICKABLE.ClickSwitch switcher;
/*     */   private final Level level;
/*     */   private final UIBonus bonus;
/*     */   private final Titles titles;
/*  27 */   private static CharSequence ¤¤Name = "¤Status";
/*     */   
/*     */   static {
/*  30 */     D.ts(UILevel.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public UILevel() {
/*  35 */     super(¤¤Name, (SPRITE)(UI.icons()).l.up);
/*     */ 
/*     */     
/*  38 */     this.section.body().setWidth(WIDTH).setHeight(1.0D);
/*     */     
/*  40 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)picker());
/*     */     
/*  42 */     int height = HEIGHT - this.section.body().height() - 16;
/*     */     
/*  44 */     this.level = new Level(height);
/*  45 */     GETTER<BOOSTABLE_O> g = new GETTER<BOOSTABLE_O>()
/*     */       {
/*     */         public BOOSTABLE_O get()
/*     */         {
/*  49 */           return (BOOSTABLE_O)HCLASS_RACE.clP(null, null);
/*     */         }
/*     */       };
/*     */     
/*  53 */     GETTER<Faction> fff = new GETTER<Faction>()
/*     */       {
/*     */         public Faction get()
/*     */         {
/*  57 */           return (Faction)FACTIONS.player();
/*     */         }
/*     */       };
/*     */     
/*  61 */     this.bonus = new UIBonus(g, fff, height)
/*     */       {
/*     */         protected boolean is(Boostable bo)
/*     */         {
/*  65 */           return true;
/*     */         }
/*     */       };
/*     */     
/*  69 */     this.titles = new Titles(height);
/*     */     
/*  71 */     this.switcher = new CLICKABLE.ClickSwitch((RENDEROBJ)this.level);
/*  72 */     this.switcher.setD(DIR.N);
/*     */ 
/*     */ 
/*     */     
/*  76 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)this.switcher);
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection picker() {
/*  81 */     GuiSection s = new GuiSection();
/*     */     
/*  83 */     s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((GAME.player().level()).info.name)
/*     */         {
/*     */           protected void clickA() {
/*  86 */             UILevel.this.switcher.set((RENDEROBJ)UILevel.this.level);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  91 */             selectedSet((UILevel.this.switcher.current() == UILevel.this.level));
/*     */           }
/*  93 */         }).setDim(180, 32).hoverSet((GAME.player().level()).info));
/*     */     
/*  95 */     s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((FACTIONS.player()).titles.info.name)
/*     */         {
/*     */           protected void clickA() {
/*  98 */             UILevel.this.switcher.set((RENDEROBJ)UILevel.this.titles);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 103 */             selectedSet((UILevel.this.switcher.current() == UILevel.this.titles));
/* 104 */             if (!selectedIs() && !hoveredIs() && (FACTIONS.player()).titles.hasNew()) {
/* 105 */               bg(COLOR.WHITE202WHITE100);
/*     */             } else {
/* 107 */               bgClear();
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 112 */         }).setDim(180, 32).hoverSet((FACTIONS.player()).titles.info));
/*     */     
/* 114 */     s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤Boosts)
/*     */         {
/*     */           protected void clickA() {
/* 117 */             UILevel.this.switcher.set((RENDEROBJ)UILevel.this.bonus);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 122 */             selectedSet((UILevel.this.switcher.current() == UILevel.this.bonus));
/*     */           }
/* 124 */         }).setDim(180, 32).hoverTitleSet(Dic.¤¤Boosts));
/*     */     
/* 126 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UILevel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */