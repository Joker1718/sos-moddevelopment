/*     */ package view.world.generator;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTitles;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.LOG;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.ToolManager;
/*     */ import view.world.WorldView;
/*     */ import world.WORLD;
/*     */ import world.WorldGen;
/*     */ 
/*     */ public class WorldViewGenerator extends VIEW.ViewSubSimple {
/*  26 */   static CharSequence ¤¤generate = "¤generate";
/*  27 */   static CharSequence ¤¤regenerate = "¤regenerate";
/*  28 */   static CharSequence ¤¤start = "¤start";
/*  29 */   static CharSequence ¤¤home = "¤home";
/*     */   
/*     */   static {
/*  32 */     D.ts(WorldViewGenerator.class);
/*     */   }
/*     */   final GameWindow window;
/*     */   final ToolManager tools;
/*     */   final IMinimap minimap;
/*     */   final Intr dummy;
/*     */   final ISidePanels panels;
/*     */   
/*  40 */   public static final ACTION loadPrint = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  44 */         if (!SPRITES.loader().isMini())
/*  45 */           SPRITES.loader().minify(true, Dic.¤¤Generating); 
/*  46 */         SPRITES.loader().print(Dic.¤¤Generating);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   boolean canSelectRace = true;
/*     */   boolean hasSeletedRace = false;
/*     */   boolean hasProfiled = false;
/*     */   boolean hasSelectedTitles = true;
/*     */   
/*     */   public WorldViewGenerator() {
/*  57 */     for (PTitles.PTitle t : (FACTIONS.player()).titles.all()) {
/*  58 */       if (t.unlocked()) {
/*  59 */         this.hasSelectedTitles = false;
/*     */       }
/*     */     } 
/*  62 */     this.window = WorldView.createwindow();
/*  63 */     this.dummy = new Intr(this);
/*  64 */     this.minimap = new IMinimap(this);
/*  65 */     this.tools = new ToolManager(this.uiManager, this.window);
/*  66 */     this.window.setZoomout(2);
/*  67 */     this.window.centererTile.set(WORLD.TWIDTH() / 2, WORLD.THEIGHT() / 2);
/*  68 */     this.panels = new ISidePanels(this.uiManager, 0);
/*  69 */     set();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setresettle(Race race) {
/*  75 */     if (VIEW.current() instanceof WorldViewGenerator) {
/*  76 */       WorldViewGenerator g = (WorldViewGenerator)VIEW.current();
/*  77 */       FACTIONS.player().setRace(race);
/*  78 */       g.hasSeletedRace = true;
/*  79 */       g.hasProfiled = true;
/*  80 */       g.canSelectRace = false;
/*  81 */       g.set();
/*     */     } else {
/*  83 */       LOG.err(VIEW.current());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void activate() {
/*  90 */     super.activate();
/*  91 */     this.window.stop();
/*  92 */     (WORLD.FOW()).toggled.set(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deactivate() {
/*  98 */     (WORLD.FOW()).toggled.set(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 104 */     this.window.hover();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(double mouseTimer, GBox text) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds, boolean should) {
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds, boolean hide) {
/* 126 */     this.window.crop((RECTANGLE)this.uiManager.viewPort());
/* 127 */     GAME.world().render(r, ds, this.window.zoomout(), (RECTANGLE)this.window.pixels(), this.window.view().x1(), this.window.view().y1());
/*     */   }
/*     */ 
/*     */   
/*     */   void reset() {
/* 132 */     this.uiManager.clear();
/* 133 */     this.dummy.add(null, null);
/* 134 */     this.tools.place(null);
/* 135 */     this.minimap.hide();
/*     */   }
/*     */   
/*     */   public void set() {
/* 139 */     reset();
/* 140 */     WorldGen g = WORLD.GEN();
/*     */     
/* 142 */     if (!this.hasSeletedRace && this.canSelectRace) {
/*     */     
/* 144 */     } else if (!this.hasProfiled) {
/*     */     
/* 146 */     } else if (!this.hasSelectedTitles && (FACTIONS.player()).titles.unlocked() > 0) {
/*     */     
/* 148 */     } else if (!g.hasGeneratedTerrain) {
/*     */     
/* 150 */     } else if (g.playerX < 0) {
/*     */     
/*     */     } else {
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\WorldViewGenerator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */