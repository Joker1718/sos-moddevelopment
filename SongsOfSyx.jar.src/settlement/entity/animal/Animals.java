/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.animal.spawning.AnimalSpawning;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.food.pasture.ROOM_PASTURE;
/*     */ import snake2d.Errors;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.keymap.RMAPS;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Animals
/*     */   extends SETT.SettResource
/*     */ {
/*     */   public final AnimalSpawning spawn;
/*     */   public RMAPS<AnimalSpecies> map;
/*     */   public final LIST<AnimalSpecies> species;
/*  45 */   public final ArrayListGrower<AnimalSpecies> caravans = new ArrayListGrower();
/*     */   
/*     */   private LIST<AnimalSpecies> sett;
/*     */   final Sprites sprites;
/*     */   
/*     */   public Animals() throws IOException {
/*  51 */     super("ANIMALS", true);
/*     */     
/*  53 */     ArrayListGrower<AnimalSpecies> all = new ArrayListGrower();
/*     */     
/*  55 */     PATH gData = PATHS.INIT().getFolder("animal");
/*  56 */     PATH gText = PATHS.TEXT().getFolder("animal");
/*  57 */     KeyMap<TILE_SHEET> sprites = new KeyMap(); byte b; int i; String[] arrayOfString;
/*  58 */     for (i = (arrayOfString = gData.getFiles()).length, b = 0; b < i; ) { String key = arrayOfString[b];
/*  59 */       Json data = new Json(gData.gets(key));
/*  60 */       Json text = new Json(gText.gets(key));
/*     */       
/*  62 */       final AnimalSpecies s = new AnimalSpecies(key, all.size(), data, text, sprites);
/*  63 */       all.add(s);
/*     */       b++; }
/*     */     
/*  66 */     this.species = (LIST<AnimalSpecies>)all;
/*  67 */     this.map = new RMAPS("ANIMAL", (LIST)all);
/*  68 */     this.spawn = new AnimalSpawning(this);
/*  69 */     this.sprites = new Sprites();
/*     */     
/*  71 */     PlacableSimple placableSimple = new PlacableSimple("kill animals")
/*     */       {
/*     */         public void place(int x, int y)
/*     */         {
/*  75 */           for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/*  76 */             if (e instanceof Animal) {
/*  77 */               ((Animal)e).kill(false, false);
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int x, int y) {
/*  85 */           for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/*  86 */             if (e instanceof Animal) {
/*  87 */               return null;
/*     */             }
/*     */           } 
/*  90 */           return E;
/*     */         }
/*     */       };
/*     */     
/*  94 */     IDebugPanelSett.add((PLACABLE)placableSimple);
/*     */     
/*  96 */     for (AnimalSpecies s : this.species) {
/*  97 */       PlacableSimple placableSimple1 = new PlacableSimple(s.name)
/*     */         {
/*     */           public void place(int x, int y) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int x, int y) {
/* 107 */             return Animals.this.isPlacable(s, x, y) ? null : E;
/*     */           }
/*     */         };
/* 110 */       IDebugPanelSett.add("animal", (PLACABLE)placableSimple1);
/* 111 */       if (s.caravanable) {
/* 112 */         this.caravans.add(s);
/*     */       }
/*     */     } 
/* 115 */     if (this.caravans.isEmpty()) {
/* 116 */       throw new Errors.DataError("No animals can be caravans");
/*     */     }
/* 118 */     PlacableSimpleTile p = new PlacableSimpleTile("control animal")
/*     */       {
/*     */         public void place(int tx, int ty)
/*     */         {
/* 122 */           for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/* 123 */             if (e instanceof Animal) {
/* 124 */               ((Animal)e).setState(State.CONTROLLED, 1.0F);
/* 125 */               e.physics.setMass(500.0D);
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 133 */           for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/* 134 */             if (e instanceof Animal)
/* 135 */               return null; 
/*     */           } 
/* 137 */           return E;
/*     */         }
/*     */       };
/*     */     
/* 141 */     IDebugPanelSett.add("animal", (PLACABLE)p);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/* 146 */     this.spawn.saver.save(saveFile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/* 152 */     this.spawn.update(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/* 157 */     this.sett = exists(SETT.WORLD_AREA());
/* 158 */     this.spawn.saver.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void generate(CapitolArea area) {
/* 163 */     this.sett = exists(area);
/*     */     
/* 165 */     if (!area.isBattle) {
/* 166 */       this.spawn.generate(this, area);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void clear() {
/* 171 */     this.spawn.saver.clear();
/*     */   }
/*     */   
/*     */   public LIST<AnimalSpecies> sett() {
/* 175 */     return this.sett;
/*     */   }
/*     */ 
/*     */   
/*     */   private LIST<AnimalSpecies> exists(CapitolArea area) {
/* 180 */     ArrayList<AnimalSpecies> res = new ArrayList(this.species.size());
/* 181 */     for (AnimalSpecies s : this.species) {
/* 182 */       if (exists(s, area))
/* 183 */         res.add(s); 
/*     */     } 
/* 185 */     return (LIST<AnimalSpecies>)res;
/*     */   }
/*     */   
/*     */   private boolean exists(AnimalSpecies s, CapitolArea area) {
/* 189 */     for (ROOM_PASTURE p : (SETT.ROOMS()).PASTURES) {
/* 190 */       if (p.species == s && !p.isAvailable(area.climate()))
/* 191 */         return false; 
/*     */     } 
/* 193 */     return true;
/*     */   }
/*     */   
/*     */   public void renderCaravan(SPRITE_RENDERER r, ShadowBatch s, double movement, int cx, int cy, RESOURCE res, int resAmount, boolean inWater, int dir, int ran) {
/* 197 */     Sprite.renderCaravan(r, s, movement, cx, cy, res, resAmount, inWater, dir, ran);
/*     */   }
/*     */   
/*     */   public void renderMount(AnimalSpecies sp, SPRITE_RENDERER r, ShadowBatch s, double movement, int cx, int cy, boolean inWater, int dir, int ran) {
/* 201 */     Sprite.renderMount(sp, r, s, movement, cx, cy, inWater, dir, ran);
/*     */   }
/*     */   
/*     */   public void renderCorpse(AnimalSpecies s, Renderer r, ShadowBatch shadows, float ds, int x, int y, int state, int rot, int ran, double statef, COLOR decay) {
/* 205 */     Sprite.renderCorpse(s, r, shadows, ds, x, y, state, rot, ran, statef, decay);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPlacable(AnimalSpecies s, int x, int y) {
/* 216 */     int x1 = x - s.hitboxSize / 2;
/* 217 */     int x2 = x + s.hitboxSize / 2;
/* 218 */     int y1 = y - s.hitboxSize / 2;
/* 219 */     int y2 = y + s.hitboxSize / 2;
/* 220 */     if (x1 < 0 || x2 >= SETT.PWIDTH || y1 < 0 || y2 >= SETT.PHEIGHT)
/* 221 */       return false; 
/* 222 */     x1 /= 64;
/* 223 */     x2 /= 64;
/* 224 */     y1 /= 64;
/* 225 */     y2 /= 64;
/* 226 */     return (!(SETT.PATH()).solidity.is(x1, y1) && !(SETT.PATH()).solidity.is(x2, y1) && 
/* 227 */       !(SETT.PATH()).solidity.is(x1, y2) && !(SETT.PATH()).solidity.is(x2, y2) && 
/* 228 */       SETT.ENTITIES().getAtPoint(x, y) == null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Animals.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */