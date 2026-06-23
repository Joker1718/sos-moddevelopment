/*     */ package world.overlay;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.raiding.RaidingMap;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.info.INFO;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDHealth;
/*     */ import world.region.pop.RDRaces;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldOverlays
/*     */ {
/*  38 */   public final OverlayTileNormal minerals = new OverlayMineral();
/*  39 */   public final OverlayRegnames regNames = new OverlayRegnames();
/*     */   
/*  41 */   public final EThings things = new EThings();
/*  42 */   public final ERegion regionOutline = new ERegion();
/*  43 */   public final OverlayExplore landmarks = new OverlayExplore();
/*  44 */   public final EPath path = new EPath();
/*  45 */   public final OverlayTileNormal climate = new OverlayClimate();
/*  46 */   public final OverlayTileNormal factions = new OverlayFaction();
/*  47 */   public final OverlayTileNormal biome = new OverlayRaceBiome();
/*  48 */   private final Edger edger = new Edger(WORLD.TWIDTH(), WORLD.THEIGHT());
/*  49 */   private final Army army = new Army();
/*  50 */   public final OverlayRegAbs raiders = new OverlayRegAbs(RaidingMap.¤¤Name, RaidingMap.¤¤desc, true)
/*     */     {
/*     */       public double value(Region reg)
/*     */       {
/*  54 */         return CLAMP.d((GAME.raiders()).entry.get(reg).security(), 0.0D, 1.0D);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(Region reg) {
/*  59 */         return (reg.faction() == FACTIONS.player() && !reg.capitol());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void renderAbove(Renderer ren, ShadowBatch s, RenderData data) {
/*  65 */         super.renderAbove(ren, s, data);
/*     */         
/*  67 */         COLOR.WHITE2WHITE.bind();
/*     */         
/*  69 */         for (RaidingMap.RaidEntryPoint c : (GAME.raiders()).entry.entrySpots()) {
/*  70 */           int x = data.transformGX(c.c().x() * 64);
/*  71 */           int y = data.transformGY(c.c().y() * 64);
/*     */           
/*  73 */           (UI.icons()).s.alert.renderScaled((SPRITE_RENDERER)ren, x, y, 4);
/*     */         } 
/*     */         
/*  76 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  81 */   public final OverlayRegAbs health = new OverlayRegAbs(RDHealth.¤¤name, RDHealth.¤¤desc, true)
/*     */     {
/*     */       public double value(Region reg)
/*     */       {
/*  85 */         return RD.HEALTH().getD(reg);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(Region reg) {
/*  90 */         return (reg.faction() == FACTIONS.player());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  95 */   public final OverlayRegAbs loyalty = new OverlayRegAbs(RDRaces.¤¤Loyalty, RDRaces.¤¤LoyaltyD, true)
/*     */     {
/*     */       public double value(Region reg)
/*     */       {
/*  99 */         return (RD.RACES()).loyaltyAll.getD(reg);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(Region reg) {
/* 104 */         return (reg.faction() == FACTIONS.player());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 109 */   public final LIST<OverlayTileNormal> togglable = (LIST<OverlayTileNormal>)new ArrayList((Object[])new OverlayTileNormal[] {
/* 110 */         new OverlayPathing(), 
/* 111 */         this.factions, 
/* 112 */         new OverlayDiplomacy(), 
/* 113 */         new OverlayMineral(), 
/* 114 */         this.climate, 
/* 115 */         this.biome, 
/* 116 */         this.raiders, 
/* 117 */         this.health, 
/* 118 */         this.loyalty
/*     */       });
/*     */   
/*     */   private Overlay current;
/*     */   
/*     */   public Overlay debug;
/*     */   
/*     */   private boolean hide;
/*     */ 
/*     */   
/*     */   public WorldOverlays() throws IOException {
/* 129 */     this.hide = false;
/*     */   }
/*     */   public void hide() {
/* 132 */     this.hide = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderBelow(Renderer r, ShadowBatch s, RenderData data, int zoomout) {
/* 138 */     if (this.current == null)
/* 139 */       return false; 
/* 140 */     Overlay o = this.current;
/* 141 */     this.current = null;
/* 142 */     boolean ret = (!this.hide && o.renderBelow(r, s, data));
/* 143 */     COLOR.unbind();
/* 144 */     OPACITY.unbind();
/* 145 */     this.hide = false;
/* 146 */     return ret;
/*     */   }
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, RenderData data, int zoomout) {
/* 150 */     if (this.hide) {
/* 151 */       this.things.clear();
/*     */       return;
/*     */     } 
/* 154 */     if (this.debug != null)
/* 155 */       this.current = this.debug; 
/* 156 */     if (this.current == null) {
/* 157 */       this.current = this.regNames;
/*     */     }
/* 159 */     this.things.render(r, s, data);
/* 160 */     this.path.render(r, s, data);
/* 161 */     this.regionOutline.renderAbove(r, s, data);
/* 162 */     this.edger.render((SPRITE_RENDERER)r, data, zoomout);
/* 163 */     if (this.current != null)
/* 164 */       this.current.renderAbove(r, s, data); 
/* 165 */     this.things.clear();
/* 166 */     COLOR.unbind();
/* 167 */     OPACITY.unbind();
/*     */   }
/*     */   
/*     */   public void hover(Region reg) {
/* 171 */     this.regionOutline.add(reg);
/* 172 */     this.regNames.exclude(reg);
/* 173 */     hoverBox(reg);
/*     */   }
/*     */   
/*     */   public void hoverEntity(WEntity ent) {
/* 177 */     this.things.hover(ent);
/* 178 */     if (ent.path() != null) {
/* 179 */       this.path.add(ent.ctx(), ent.cty(), ent.path().destX(), ent.path().destY(), ent.path().treaty());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverArmy(WArmy army) {
/* 185 */     if (army == null) {
/* 186 */       this.army.add(null);
/*     */     }
/*     */     else {
/*     */       
/* 190 */       this.army.add(army.faction());
/* 191 */       hoverEntity((WEntity)army);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverArmy(Faction f) {
/* 197 */     this.army.add(f);
/*     */   }
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
/*     */   public void hoverBox(Region region) {
/* 214 */     if (region == null) {
/*     */       return;
/*     */     }
/* 217 */     int x1 = region.cx() * 64;
/* 218 */     int y1 = region.cy() * 64;
/*     */     
/* 220 */     if (region.capitol()) {
/* 221 */       this.things.hover(x1 - 64 - 32, y1 - 64 - 32, 256, 256, (COLOR)region.faction().banner().colorBG(), true);
/* 222 */     } else if (region.faction() != null) {
/* 223 */       this.things.hover(x1 - 64 + 16, y1 - 64 + 16, 160, 160, (COLOR)region.faction().banner().colorBG(), false);
/*     */     } else {
/* 225 */       this.things.hover(x1 - 64 + 16, y1 - 64 + 16, 160, 160, COLOR.WHITE65, false);
/*     */     } 
/* 227 */     WORLD.MINIMAP().hilight(region);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Overlay
/*     */   {
/*     */     public void add() {
/* 239 */       (WORLD.OVERLAY()).current = this;
/*     */     }
/*     */     
/*     */     public boolean added() {
/* 243 */       return ((WORLD.OVERLAY()).current == this);
/*     */     }
/*     */     
/*     */     protected void remove() {
/* 247 */       (WORLD.OVERLAY()).current = null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 252 */     private static Coo coo = new Coo();
/*     */     
/*     */     public abstract void renderAbove(Renderer param1Renderer, ShadowBatch param1ShadowBatch, RenderData param1RenderData);
/*     */     
/*     */     protected COORDINATE mouse(RenderData data) {
/* 257 */       int dx = VIEW.mouse().x() - (data.absBounds().x1() >> CORE.renderer().getZoomout());
/* 258 */       int dy = VIEW.mouse().y() - (data.absBounds().y1() >> CORE.renderer().getZoomout());
/* 259 */       dx <<= CORE.renderer().getZoomout();
/* 260 */       dy <<= CORE.renderer().getZoomout();
/*     */       
/* 262 */       dx += data.gBounds().x1();
/* 263 */       dy += data.gBounds().y1();
/* 264 */       coo.set((dx / 64), (dy / 64));
/*     */ 
/*     */       
/* 267 */       return (COORDINATE)coo;
/*     */     }
/*     */     
/*     */     public abstract boolean renderBelow(Renderer param1Renderer, ShadowBatch param1ShadowBatch, RenderData param1RenderData);
/*     */   }
/*     */   
/*     */   public static class OverlayTile extends Overlay {
/*     */     private boolean above;
/*     */     private boolean below;
/*     */     
/*     */     public OverlayTile(boolean above, boolean below) {
/* 278 */       this.above = above;
/* 279 */       this.below = below;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/* 285 */       if (this.above) {
/* 286 */         RenderData.RenderIterator it = data.onScreenTiles(0, 0, 0, 0);
/* 287 */         while (it.has()) {
/* 288 */           renderAbove((SPRITE_RENDERER)r, s, it);
/* 289 */           it.next();
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean renderBelow(Renderer r, ShadowBatch s, RenderData data) {
/* 297 */       if (this.below) {
/* 298 */         RenderData.RenderIterator it = data.onScreenTiles(0, 0, 0, 0);
/* 299 */         while (it.has()) {
/* 300 */           renderBelow((SPRITE_RENDERER)r, s, it);
/* 301 */           it.next();
/*     */         } 
/*     */       } 
/* 304 */       return this.below;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {}
/*     */ 
/*     */     
/*     */     protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {}
/*     */ 
/*     */     
/*     */     protected static void renderUnder(int m, SPRITE_RENDERER r, RenderData.RenderIterator it) {
/* 315 */       (SPRITES.cons()).BIG.filled.render(r, m, it.x(), it.y());
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class OverlayTileNormal
/*     */     extends OverlayTile {
/*     */     public final INFO info;
/*     */     
/*     */     public OverlayTileNormal(CharSequence name, CharSequence desc, boolean above, boolean below) {
/* 324 */       super(above, below);
/* 325 */       this.info = new INFO(name, desc);
/*     */     }
/*     */ 
/*     */     
/*     */     public void add() {
/* 330 */       super.add();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\WorldOverlays.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */