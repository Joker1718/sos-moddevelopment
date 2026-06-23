/*     */ package view.world;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.tilemap.ground.Ground;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.Tool;
/*     */ import view.tool.ToolConfig;
/*     */ import view.tool.ToolManager;
/*     */ import view.world.ui.WorldHoverer;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.landmark.WorldLandmark;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ToolDefault
/*     */   extends Tool
/*     */ {
/*     */   private boolean exploring = false;
/*  37 */   private final ToolConfig config = new ToolConfig() {  }
/*     */   ;
/*     */   public ToolDefault(ToolManager manager) {
/*  40 */     super(manager);
/*     */   }
/*     */   
/*     */   private static final int tabs = 5;
/*     */   
/*     */   protected void updateHovered(float ds, GameWindow window) {
/*  46 */     this.exploring &= MButt.RIGHT.isDown();
/*     */     
/*  48 */     update(ds, window);
/*  49 */     if (this.exploring) {
/*  50 */       explore(window);
/*     */     } else {
/*  52 */       hover((COORDINATE)window.pixel(), window);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void hover(COORDINATE coo, GameWindow window) {
/*  59 */     if (!WORLD.PIXELS().holdsPoint(coo))
/*     */       return; 
/*  61 */     WEntity e = WORLD.ENTITIES().getTallest(coo);
/*  62 */     GBox box = VIEW.hoverBox();
/*  63 */     if (e != null && (e.faction() == FACTIONS.player() || !WORLD.FOW().is((COORDINATE)window.tile()))) {
/*  64 */       WORLD.OVERLAY().hoverEntity(e);
/*  65 */       WorldHoverer.hover((GUI_BOX)box, e);
/*     */     } else {
/*     */       
/*  68 */       Region reg = (Region)(WORLD.REGIONS()).centre.get((COORDINATE)window.tile());
/*  69 */       if (reg != null) {
/*  70 */         WORLD.OVERLAY().hover(reg);
/*  71 */         (VIEW.world()).UI.regions.hover(reg, (GUI_BOX)box);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  77 */     (VIEW.world()).UI.factions.hover(window.tile().x(), window.tile().y());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(float ds, GameWindow window) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderHovered(SPRITE_RENDERER r, float ds, GameWindow window, GBox box) {
/*  89 */     if (this.exploring) {
/*  90 */       (SPRITES.cons()).BIG.dashed.render(r, 0, window.tile().rel().x(), window.tile().rel().y());
/*  91 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.questionmark);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean rightClick() {
/* 100 */     this.exploring = true;
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void click(GameWindow window) {
/* 106 */     if (!WORLD.PIXELS().holdsPoint((COORDINATE)window.pixel())) {
/*     */       return;
/*     */     }
/* 109 */     if ((VIEW.world()).UI.factions.openIs()) {
/* 110 */       Region region = (Region)(WORLD.REGIONS()).centre.get((COORDINATE)window.tile());
/* 111 */       if (region != null && 
/* 112 */         region.faction() instanceof FactionNPC) {
/* 113 */         (VIEW.world()).UI.factions.open((FactionNPC)region.faction());
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 118 */     for (WEntity e : WORLD.ENTITIES().fill(window.pixel().x(), window.pixel().y())) {
/* 119 */       if (e != null && (e.faction() == FACTIONS.player() || !WORLD.FOW().is((COORDINATE)window.tile())) && 
/* 120 */         e instanceof WArmy) {
/* 121 */         WArmy a = (WArmy)e;
/* 122 */         if (a.faction() == FACTIONS.player() || (S.get()).developer) {
/* 123 */           (VIEW.world()).UI.armies.open(a);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 131 */     Region reg = (Region)(WORLD.REGIONS()).centre.get((COORDINATE)window.tile());
/* 132 */     if (reg != null) {
/* 133 */       (VIEW.world()).UI.regions.open(reg, true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ToolConfig defaultConfig() {
/* 142 */     return this.config;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void explore(GameWindow win) {
/* 148 */     if (!WORLD.PIXELS().holdsPoint((COORDINATE)win.pixel()))
/*     */       return; 
/* 150 */     int tx = win.tile().x();
/* 151 */     int ty = win.tile().y();
/*     */     
/* 153 */     GBox b = VIEW.hoverBox();
/*     */     
/* 155 */     (WORLD.OVERLAY()).landmarks.add();
/*     */ 
/*     */     
/* 158 */     b.title(((TERRAIN)TERRAINS.world.get(tx, ty)).name);
/* 159 */     b.add((SPRITE)(SPRITES.icons()).m.crossair);
/* 160 */     b.tab(1);
/* 161 */     b.add((SPRITE)b.text().add(tx));
/* 162 */     b.tab(2);
/* 163 */     b.add((SPRITE)b.text().add(ty));
/* 164 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 168 */     b.textLL(Ground.¤¤moisture);
/* 169 */     b.tab(5);
/* 170 */     b.add((SPRITE)GFORMAT.perc(b.text(), WORLD.MOISTURE().get(tx, ty)));
/* 171 */     b.NL();
/*     */     
/* 173 */     CLIMATE z = (CLIMATE)(WORLD.CLIMATE()).getter.get(tx, ty);
/* 174 */     b.textLL((CLIMATES.INFO()).name);
/* 175 */     b.tab(5);
/* 176 */     b.text(z.name);
/* 177 */     b.NL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     WorldLandmark a = (WorldLandmark)(WORLD.LANDMARKS()).setter.get(tx, ty);
/* 184 */     if (a != null) {
/* 185 */       b.NL(8);
/* 186 */       (WORLD.OVERLAY()).landmarks.hover(a);
/* 187 */       b.textLL((CharSequence)a.name);
/* 188 */       b.NL();
/* 189 */       b.text((CharSequence)a.description);
/* 190 */       b.NL();
/*     */     } 
/*     */ 
/*     */     
/* 194 */     if ((S.get()).developer) {
/* 195 */       b.add((SPRITE)b.text().add(WORLD.FOW().is(tx, ty)));
/* 196 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\ToolDefault.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */