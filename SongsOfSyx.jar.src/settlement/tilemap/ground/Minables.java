/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import init.resources.Minable;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.map.MAP_OBJECTE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.keymap.MAPSAVE;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Minables
/*     */ {
/*  40 */   private long[] amounts = new long[RESOURCES.minables().all().size()];
/*  41 */   private final Bitsmap1D types = new Bitsmap1D(0, 5, SETT.TAREA)
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void set(int index, int value) {
/*  49 */         int am = Minables.this.amount.get(index);
/*  50 */         Minables.this.amounts[get(index)] = Minables.this.amounts[get(index)] - am;
/*  51 */         super.set(index, value);
/*  52 */         Minables.this.amounts[get(index)] = Minables.this.amounts[get(index)] + am;
/*  53 */         Minables.this.amounts[get(index)] = Math.max(0L, Minables.this.amounts[get(index)]);
/*     */       }
/*     */     };
/*  56 */   private final Bitsmap1D amount = new Bitsmap1D(0, 6, SETT.TAREA)
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void set(int index, int value) {
/*  64 */         Minables.this.amounts[Minables.this.types.get(index)] = Minables.this.amounts[Minables.this.types.get(index)] - get(index);
/*  65 */         super.set(index, value);
/*  66 */         Minables.this.amounts[Minables.this.types.get(index)] = Minables.this.amounts[Minables.this.types.get(index)] + get(index);
/*  67 */         Minables.this.amounts[Minables.this.types.get(index)] = Math.max(0L, Minables.this.amounts[Minables.this.types.get(index)]);
/*     */       }
/*     */     };
/*     */   
/*  71 */   private final Bitsmap1D richness = new Bitsmap1D(0, 1, SETT.TAREA);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_OBJECTE<Minable> getter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_INTE amountInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_DOUBLEE amountD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_DOUBLEE value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final PlacableSimpleTile CLEAR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final PlacableSimpleTile INCREASE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final PlacableSimpleTile DECREASE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final DIR[] dirs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final DOUBLE_O<Minable> totals;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Minables() {
/* 138 */     this.getter = new MAP_OBJECTE<Minable>()
/*     */       {
/*     */         public Minable get(int tile)
/*     */         {
/* 142 */           if (Minables.this.amount.get(tile) == 0)
/* 143 */             return null; 
/* 144 */           return (Minable)RESOURCES.minables().getAt(Minables.this.types.get(tile));
/*     */         }
/*     */ 
/*     */         
/*     */         public Minable get(int tx, int ty) {
/* 149 */           return get(tx + ty * SETT.TWIDTH);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int tile, Minable object) {
/* 154 */           Minable old = get(tile);
/*     */           
/* 156 */           if (object == null) {
/* 157 */             Minables.this.amount.set(tile, 0);
/*     */           } else {
/* 159 */             Minables.this.types.set(tile, object.index);
/* 160 */             Minables.this.amount.set(tile, 1);
/*     */           } 
/*     */           
/* 163 */           if (object != old) {
/* 164 */             SETT.TILE_MAP().miniCUpdate(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */           }
/*     */         }
/*     */         
/*     */         public void set(int tx, int ty, Minable object) {
/* 169 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 170 */             set(tx + ty * SETT.TWIDTH, object);
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 175 */     this.amountInt = new MAP_INTE()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/* 179 */           if (SETT.IN_BOUNDS(tx, ty))
/* 180 */             return get(tx + ty * SETT.TWIDTH); 
/* 181 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/* 186 */           return Minables.this.amount.get(tile);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tx, int ty, int value) {
/* 193 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 194 */             set(tx + ty * SETT.TWIDTH, value);
/*     */           }
/*     */ 
/*     */           
/* 198 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 203 */           Minable old = (Minable)Minables.this.getter.get(tile);
/* 204 */           if (value < 0)
/* 205 */             value = 0; 
/* 206 */           if (value > Minables.this.amount.maxValue()) {
/* 207 */             value = Minables.this.amount.maxValue();
/*     */           }
/* 209 */           Minables.this.amount.set(tile, value);
/* 210 */           if (Minables.this.getter.get(tile) != old)
/* 211 */             SETT.TILE_MAP().miniCUpdate(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/* 212 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 216 */     this.amountD = new MAP_DOUBLEE()
/*     */       {
/* 218 */         private final double i = 1.0D / Minables.this.amount.maxValue();
/*     */ 
/*     */         
/*     */         public double get(int tx, int ty) {
/* 222 */           if (SETT.IN_BOUNDS(tx, ty))
/* 223 */             return get(tx + ty * SETT.TWIDTH); 
/* 224 */           return 0.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 230 */           return Minables.this.amount.get(tile) * this.i;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 236 */           Minables.this.amountInt.set(tile, (int)(value * Minables.this.amount.maxValue()));
/* 237 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 242 */           if (SETT.IN_BOUNDS(tx, ty))
/* 243 */             set(tx + ty * SETT.TWIDTH, value); 
/* 244 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 248 */     this.value = new MAP_DOUBLEE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 252 */           if (SETT.IN_BOUNDS(tx, ty))
/* 253 */             return get(tx + ty * SETT.TWIDTH); 
/* 254 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 259 */           return Minables.this.richness.get(tile);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 264 */           Minables.this.richness.set(tile, (int)(value * 1.0D));
/* 265 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 270 */           if (SETT.IN_BOUNDS(tx, ty))
/* 271 */             set(tx + ty * SETT.TWIDTH, value); 
/* 272 */           return this;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 277 */     this.CLEAR = new PlacableSimpleTile("clear exavatables")
/*     */       {
/*     */         public String name()
/*     */         {
/* 281 */           return "clear exavatables";
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 286 */           return (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.pickaxe, (SPRITE)(SPRITES.icons()).m.cancel);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 291 */           return SETT.IN_BOUNDS(tx, ty) ? null : E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty) {
/* 296 */           Minables.this.amountInt.set(tx, ty, 0);
/*     */         }
/*     */       };
/* 299 */     this.INCREASE = new PlacableSimpleTile("decrease")
/*     */       {
/*     */         public String name()
/*     */         {
/* 303 */           return "increase";
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 308 */           return (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.pickaxe, (SPRITE)(SPRITES.icons()).m.arrow_up);
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty) {
/* 313 */           Minables.this.amountInt.increment(tx, ty, 8);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 318 */           return SETT.IN_BOUNDS(tx, ty) ? null : E;
/*     */         }
/*     */       };
/* 321 */     this.DECREASE = new PlacableSimpleTile("decrease")
/*     */       {
/*     */         public String name()
/*     */         {
/* 325 */           return "decrease";
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 330 */           return (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.pickaxe, (SPRITE)(SPRITES.icons()).m.arrow_down);
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty) {
/* 335 */           Minables.this.amountInt.increment(tx, ty, -8);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 340 */           return SETT.IN_BOUNDS(tx, ty) ? null : E;
/*     */         }
/*     */       };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 380 */     this
/* 381 */       .dirs = new DIR[] { DIR.W, DIR.NW, DIR.N };
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
/*     */ 
/*     */     
/* 440 */     this.totals = new DOUBLE_O<Minable>()
/*     */       {
/*     */         public double getD(Minable t)
/*     */         {
/* 444 */           return Minables.this.amounts[t.index()] / Minables.this.amount.maxValue();
/*     */         }
/*     */       };
/*     */     final PlacableMulti undo = new PlacableMulti("minerals remove") {
/*     */         public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */           Minables.this.getter.set(tx, ty, null);
/*     */         }
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */           return Minables.this.getter.is(tx, ty) ? null : "";
/*     */         }
/*     */       };
/*     */     IDebugPanelSett.add((PLACABLE)placableMulti);
/*     */     for (Minable m : RESOURCES.minables().all()) {
/*     */       IDebugPanelSett.add((PLACABLE)new PlacableMulti("mineral " + String.valueOf(m.resource.name)) {
/*     */             private final CharSequence name;
/*     */             
/*     */             public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */               if (Minables.this.getter.is(tx, ty, m)) {
/*     */                 Minables.this.amountD.increment(tx, ty, 0.1D);
/*     */               } else {
/*     */                 Minables.this.getter.set(tx, ty, m);
/*     */               } 
/*     */             }
/*     */             
/*     */             public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */               if (!SETT.IN_BOUNDS(tx, ty))
/*     */                 return ""; 
/*     */               if ((SETT.PATH()).solidity.is(tx, ty))
/*     */                 return ""; 
/*     */               if ((SETT.ROOMS()).map.is(tx, ty))
/*     */                 return ""; 
/*     */               return null;
/*     */             }
/*     */             
/*     */             public CharSequence name() {
/*     */               return this.name;
/*     */             }
/*     */             
/*     */             public SPRITE getIcon() {
/*     */               return (SPRITE)m.resource.icon();
/*     */             }
/*     */             
/*     */             public PLACABLE getUndo() {
/*     */               return undo;
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */   
/*     */   void save(FilePutter saveFile) {
/*     */     MAPSAVE.saveMeta(saveFile, RESOURCES.minables().all());
/*     */     this.amount.save(saveFile);
/*     */     this.types.save(saveFile);
/*     */     this.richness.save(saveFile);
/*     */     saveFile.lsE(this.amounts);
/*     */   }
/*     */   
/*     */   void load(FileGetter saveFile) throws IOException {
/*     */     int[] order = MAPSAVE.saveWash(saveFile, RESOURCES.minables().all(), -1);
/*     */     this.amount.load(saveFile);
/*     */     this.types.load(saveFile);
/*     */     this.richness.load(saveFile);
/*     */     saveFile.lsE(this.amounts);
/*     */     if (order != null) {
/*     */       int i;
/*     */       for (i = 0; i < SETT.TAREA; i++) {
/*     */         int oi = this.types.get(i);
/*     */         int ni = order[oi];
/*     */         if (ni == -1) {
/*     */           this.amount.set(i, 0);
/*     */           this.types.set(i, 0);
/*     */         } else {
/*     */           this.types.set(i, ni);
/*     */         } 
/*     */       } 
/*     */       Arrays.fill(this.amounts, 0L);
/*     */       for (i = 0; i < SETT.TAREA; i++)
/*     */         this.amounts[((Minable)this.getter.get(i)).resource.index()] = this.amounts[((Minable)this.getter.get(i)).resource.index()] + this.amount.get(i); 
/*     */     } 
/*     */   }
/*     */   
/*     */   void render(Renderer r, int tile, int ran, int x, int y) {
/*     */     double d = this.amountD.get(tile);
/*     */     if (d == 0.0D)
/*     */       return; 
/*     */     d *= 0.5D + 0.5D * this.value.get(tile);
/*     */     int t = (int)(d * 8.0D);
/*     */     t = CLAMP.i(t, 0, 3);
/*     */     t *= 8;
/*     */     t += ran & 0x7;
/*     */     ran >>= 3;
/*     */     Minable m = (Minable)RESOURCES.minables().getAt(this.types.get(tile));
/*     */     m.sheet.render((SPRITE_RENDERER)r, t, x, y);
/*     */     int a = (int)(d * 12.0D);
/*     */     a = (int)Math.ceil(a);
/*     */     int iters = CLAMP.i(a / 3, 0, 3);
/*     */     if (iters > 0) {
/*     */       int dd = ran % 3;
/*     */       ran >>= 2;
/*     */       for (int i = 0; i < iters; i++) {
/*     */         int tt = ran & 0x1F;
/*     */         ran >>= 5;
/*     */         DIR dir = this.dirs[dd];
/*     */         dd++;
/*     */         dd %= 3;
/*     */         m.sheet.render((SPRITE_RENDERER)r, tt, x + dir.x() * 32, y + dir.y() * 32);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   COLOR miniC(ColorImp col, COLOR ground, int tx, int ty) {
/*     */     Minable m = (Minable)this.getter.get(tx, ty);
/*     */     col.interpolate(m.miniColor, ground, 0.5D + this.amountD.get(tx, ty) * 0.5D);
/*     */     for (DIR d : DIR.ORTHO) {
/*     */       if (this.getter.get(tx, ty, d) != m)
/*     */         return (COLOR)col.shadeSelf(0.75D); 
/*     */     } 
/*     */     return (COLOR)col;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Minables.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */