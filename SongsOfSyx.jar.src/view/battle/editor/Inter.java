/*     */ package view.battle.editor;
/*     */ import init.constant.C;
/*     */ import init.constant.Config;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import world.WORLD;
/*     */ 
/*     */ class Inter extends Interrupter {
/*  23 */   public ArmySide player = new ArmySide();
/*  24 */   public ArmySide enemy = new ArmySide();
/*     */   
/*  26 */   private Army current = new Army(this.player, this.enemy);
/*  27 */   private Placer placer = new Placer(this.player, this.enemy);
/*     */ 
/*     */   
/*     */   public Inter(InterManager m) {
/*  31 */     pin();
/*  32 */     persistantSet();
/*  33 */     show(m);
/*     */     
/*  35 */     double pow = ((Config.battle()).MEN_PER_DIVISION * (Config.battle()).DIVISIONS_PER_ARMY) * (0.1D + RND.rFloat() * 1.2D);
/*     */     
/*  37 */     this.player.generate(pow);
/*  38 */     this.enemy.generate(pow);
/*     */ 
/*     */     
/*  41 */     GuiSection buttons = new GuiSection();
/*     */     
/*  43 */     buttons.add((RENDEROBJ)new GButt.ButtPanel(Dic.¤¤OK)
/*     */         {
/*     */           protected void clickA() {
/*  46 */             (VIEW.b()).editor.tools.place((PLACABLE)Inter.this.placer);
/*  47 */             if (!(WORLD.GEN()).hasGeneratedTerrain) {
/*  48 */               Inter.this.placer.generate.exe();
/*     */             }
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  55 */             activeSet((Inter.this.player.divs.size() > 0 && Inter.this.enemy.divs.size() > 0));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  60 */     buttons.addRelBody(8, DIR.E, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Clear)
/*     */         {
/*     */           protected void clickA() {
/*  63 */             Inter.this.player.clear();
/*  64 */             Inter.this.enemy.clear();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     this.current.addRelBody(8, DIR.S, (RENDEROBJ)buttons);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     GPanel pan = new GPanel();
/*  77 */     pan.setBig();
/*  78 */     pan.inner().setDim(this.current.body().width(), this.current.body().height());
/*  79 */     pan.body.centerIn((BODY_HOLDER)this.current);
/*  80 */     pan.setTitle(Army.¤¤name);
/*  81 */     this.current.add((RENDEROBJ)pan);
/*  82 */     this.current.moveLastToBack();
/*  83 */     this.current.body().moveCY((C.HEIGHT() / 2));
/*  84 */     this.current.body().moveCX((C.WIDTH() / 2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  92 */     if (!(VIEW.b()).editor.tools.placer.isActivated())
/*  93 */       return this.current.hover(mCoo); 
/*  94 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  99 */     if (!(VIEW.b()).editor.tools.placer.isActivated() && button == MButt.LEFT) {
/* 100 */       this.current.click();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 105 */     if (!(VIEW.b()).editor.tools.placer.isActivated()) {
/* 106 */       this.current.hoverInfoGet((GUI_BOX)text);
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 111 */     if (!(VIEW.b()).editor.tools.placer.isActivated())
/* 112 */       this.current.render((SPRITE_RENDERER)r, ds); 
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 118 */     (VIEW.b()).editor.tools.placer.isActivated();
/* 119 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\Inter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */