/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.Growable;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TGrowable
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   public final Growable growable;
/*  39 */   private static CharSequence ¤¤Ripe = "(Ripe)";
/*  40 */   private static CharSequence ¤¤RipeNot = "(Not Ripe)";
/*  41 */   private static CharSequence ¤¤Name = "Wild {0}";
/*     */   static {
/*  43 */     D.ts(TGrowable.class);
/*     */   }
/*     */   
/*     */   public final int gIndex;
/*  47 */   private static final Bits bsize = new Bits(15);
/*  48 */   private static final Bits bfruit = new Bits(240);
/*  49 */   private static final Bit doJob = new Bit(256);
/*  50 */   private final double sizeI = 0.06666666666666667D;
/*     */   
/*  52 */   private final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/*  54 */       private final SoundRace sound = AUDIO.race("CLEAR_BUSH");
/*     */ 
/*     */ 
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty) {
/*  59 */         TGrowable.this.size.increment(tx, ty, -3);
/*     */         
/*  61 */         if ((SETT.WEATHER()).growthRipe.cropsAreRipe())
/*  62 */           return TGrowable.this.growable.resource; 
/*  63 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/*  68 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/*  73 */         int am = (int)Math.ceil(TGrowable.this.resource.get(tx, ty) / 4.0D);
/*  74 */         TGrowable.this.shared.NADA.placeFixed(tx, ty);
/*  75 */         return am;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/*  80 */         return this.sound;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEasilyCleared() {
/*  85 */         return true;
/*     */       }
/*     */     };
/*     */   
/*  89 */   public final TAmount size = new TAmount(11, name())
/*     */     {
/*     */       public int get(int tile)
/*     */       {
/*  93 */         if (SETT.TERRAIN().get(tile) == TGrowable.this) {
/*  94 */           return CLAMP.i(1 + TGrowable.bsize.get(TGrowable.this.shared.data.get(tile)), 1, this.max);
/*     */         }
/*  96 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public MAP_INTE set(int tile, int value) {
/* 101 */         if (value <= 0) {
/* 102 */           if (SETT.TERRAIN().get(tile) == TGrowable.this)
/* 103 */             (SETT.TERRAIN()).NADA.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/*     */         } else {
/* 105 */           if (SETT.TERRAIN().get(tile) != TGrowable.this)
/* 106 */             TGrowable.this.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/* 107 */           int d = TGrowable.this.shared.data.get(tile);
/* 108 */           d = TGrowable.bsize.set(d, CLAMP.i(value - 1, 0, TGrowable.bsize.mask));
/* 109 */           TGrowable.this.shared.data.set(tile, d);
/*     */         } 
/* 111 */         return this;
/*     */       }
/*     */     };
/*     */   
/* 115 */   public final MAP_BOOLEANE job = new MAP_BOOLEANE()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/* 119 */         return is(tx + ty * SETT.TWIDTH);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(int tile) {
/* 124 */         return (SETT.TERRAIN().get(tile) instanceof TGrowable && TGrowable.doJob.is(TGrowable.this.shared.data.get(tile)));
/*     */       }
/*     */ 
/*     */       
/*     */       public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 129 */         return set(tx + ty * SETT.TWIDTH, value);
/*     */       }
/*     */ 
/*     */       
/*     */       public MAP_BOOLEANE set(int tile, boolean value) {
/* 134 */         TGrowable.this.shared.data.set(tile, TGrowable.doJob.set(TGrowable.this.shared.data.get(tile), value));
/* 135 */         return this;
/*     */       }
/*     */     };
/*     */   
/* 139 */   public final MAP_INTE resource = new MAP_INTE()
/*     */     {
/*     */       public int get(int tx, int ty)
/*     */       {
/* 143 */         return CLAMP.i(TGrowable.bfruit.get(TGrowable.this.shared.data.get(tx, ty)), 0, TGrowable.this.size.get(tx, ty));
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(int tile) {
/* 148 */         return CLAMP.i(TGrowable.bfruit.get(TGrowable.this.shared.data.get(tile)), 0, TGrowable.this.size.get(tile));
/*     */       }
/*     */ 
/*     */       
/*     */       public MAP_INTE set(int tx, int ty, int value) {
/* 153 */         return set(tx + ty * SETT.TWIDTH, value);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public MAP_INTE set(int tile, int value) {
/* 159 */         value = CLAMP.i(value, 0, 15);
/*     */         
/* 161 */         int data = TGrowable.this.shared.data.get(tile);
/*     */         
/* 163 */         if (!TGrowable.this.is(tile)) {
/* 164 */           TGrowable.this.size.set(tile, value);
/* 165 */           TGrowable.this.shared.data.set(tile, TGrowable.bfruit.set(data, value));
/* 166 */           return this;
/*     */         } 
/*     */         
/* 169 */         value = CLAMP.i(value, 0, TGrowable.this.size.get(tile));
/* 170 */         int old = TGrowable.bfruit.get(data);
/* 171 */         TGrowable.this.shared.data.set(tile, TGrowable.bfruit.set(data, value));
/* 172 */         if (old == 0 && value > 0 && TGrowable.doJob.is(data) && (SETT.JOBS()).getter.get(tile) == null) {
/* 173 */           boolean b = (SETT.JOBS()).planMode.is();
/* 174 */           (SETT.JOBS()).planMode.set(false);
/* 175 */           (SETT.JOBS()).clearss.food.placer().place(tile % SETT.TWIDTH, tile / SETT.TWIDTH, null, null);
/* 176 */           (SETT.JOBS()).planMode.set(b);
/*     */         } 
/* 178 */         return this;
/*     */       }
/*     */     };
/*     */   
/*     */   static LIST<TGrowable> make(Terrain t) {
/* 183 */     ArrayList<TGrowable> all = new ArrayList(RESOURCES.growable().all().size());
/* 184 */     for (Growable g : RESOURCES.growable().all()) {
/* 185 */       all.add(new TGrowable(t, g));
/*     */     }
/* 187 */     IDebugPanelSett.add((PLACABLE)new PlacableMulti("TGrowable increase size")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/* 191 */             if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable) {
/* 192 */               TGrowable g = (TGrowable)SETT.TERRAIN().get(tx, ty);
/* 193 */               g.size.increment(tx, ty, 1);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 199 */             if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable) {
/* 200 */               return null;
/*     */             }
/* 202 */             return E;
/*     */           }
/*     */         });
/*     */     
/* 206 */     IDebugPanelSett.add((PLACABLE)new PlacableMulti("TGrowable decrease size")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/* 210 */             if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable) {
/* 211 */               TGrowable g = (TGrowable)SETT.TERRAIN().get(tx, ty);
/* 212 */               g.size.increment(tx, ty, -1);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 218 */             if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable) {
/* 219 */               return null;
/*     */             }
/* 221 */             return E;
/*     */           }
/*     */         });
/*     */     
/* 225 */     IDebugPanelSett.add((PLACABLE)new PlacableMulti("TGrowable increase res")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/* 229 */             if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable) {
/* 230 */               TGrowable g = (TGrowable)SETT.TERRAIN().get(tx, ty);
/* 231 */               g.resource.increment(tx, ty, 1);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 237 */             if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable) {
/* 238 */               return null;
/*     */             }
/* 240 */             return E;
/*     */           }
/*     */         });
/*     */     
/* 244 */     IDebugPanelSett.add((PLACABLE)new PlacableMulti("TGrowable decrease res")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/* 248 */             if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable) {
/* 249 */               TGrowable g = (TGrowable)SETT.TERRAIN().get(tx, ty);
/* 250 */               g.resource.increment(tx, ty, -1);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 256 */             if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable) {
/* 257 */               return null;
/*     */             }
/* 259 */             return E;
/*     */           }
/*     */         });
/*     */     
/* 263 */     return (LIST<TGrowable>)all;
/*     */   }
/*     */ 
/*     */   
/*     */   private TGrowable(Terrain t, Growable g) {
/* 268 */     super("GROWABLE_" + g.resource.key, t, (CharSequence)(new Str(¤¤Name)).insert(0, g.resource.name), (SPRITE)g.resource.icon(), t.colors.minimap.growable);
/* 269 */     this.growable = g;
/* 270 */     this.gIndex = g.index();
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/* 275 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/* 280 */     if (!is(tx, ty)) {
/* 281 */       placeRaw(tx, ty);
/* 282 */       this.size.set(tx, ty, 1);
/*     */     } 
/* 284 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isEdible(int tx, int ty) {
/* 288 */     return (RESOURCES.EDI().get(this.growable.resource) != null && (SETT.WEATHER()).growthRipe.cropsAreRipe());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 294 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 299 */     i.countVegetation();
/* 300 */     this.growable.sprite.render(r, s, i, this.size.DM.get(i.tile()), bfruit.get(data) * 0.06666666666666667D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 305 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 311 */     return AVAILABILITY.PENALTY2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 316 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box, int tx, int ty) {
/* 322 */     box.add((SPRITE)this.growable.resource.icon());
/* 323 */     super.hoverInfo(box, tx, ty);
/* 324 */     box.tab(6);
/* 325 */     box.add((SPRITE)GFORMAT.iofkInv(box.text(), this.resource.get(tx, ty), this.size.get(tx, ty)));
/* 326 */     box.text((SETT.WEATHER()).growthRipe.cropsAreRipe() ? ¤¤Ripe : ¤¤RipeNot);
/*     */ 
/*     */     
/* 329 */     box.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 334 */     COLOR col = (SETT.GROUND()).minimap.miniC(x, y);
/* 335 */     c.interpolate(col, this.miniC, 0.25D + 0.75D * this.size.DM.get(x, y));
/* 336 */     return (COLOR)c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TGrowable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */