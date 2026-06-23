/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.tilemap.TILE_FIXABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class TDestroyed
/*     */   extends Terrain.TerrainTile
/*     */   implements TILE_FIXABLE, TerrainDiagonal.Diagonalizer
/*     */ {
/*  23 */   private static CharSequence ¤¤broken = "¤broken {0}";
/*     */   static {
/*  25 */     D.ts(TDestroyed.class);
/*     */   }
/*     */ 
/*     */   
/*  29 */   private final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/*     */       public RESOURCE clear1(int tx, int ty)
/*     */       {
/*  33 */         TDestroyed.this.shared.NADA.placeFixed(tx, ty);
/*  34 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/*  39 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/*  44 */         TDestroyed.this.shared.NADA.placeFixed(tx, ty);
/*  45 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/*  50 */         return TDestroyed.this.get(tx, ty).clearing().sound(tx, ty);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEasilyCleared() {
/*  55 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void destroy(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean canDestroy(int tx, int ty) {
/*  66 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public double strength() {
/*  71 */         return 0.0D;
/*     */       }
/*     */     };
/*     */   
/*     */   TDestroyed(Terrain t) {
/*  76 */     super("DESTROYED", t, "", (SPRITE)(SPRITES.icons()).m.cancel, (COLOR)new ColorImp(80, 60, 60));
/*     */   }
/*     */   
/*     */   public CharSequence name(int tx, int ty) {
/*  80 */     Str.TMP.clear().add(¤¤broken);
/*  81 */     Str.TMP.insert(0, get(tx, ty).name());
/*  82 */     return (CharSequence)Str.TMP;
/*     */   }
/*     */   
/*     */   public Terrain.TerrainTile get(int tx, int ty) {
/*  86 */     int i = this.shared.data.get(tx, ty) & 0xFF;
/*  87 */     Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.all().get(i);
/*  88 */     if (t != null && t instanceof TDestoryable) {
/*  89 */       return t;
/*     */     }
/*  91 */     return (SETT.TERRAIN()).NADA;
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/*  96 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends Terrain.TerrainTile & TDestoryable> void place(int tx, int ty, T t, int data) {
/* 101 */     int d = data << 9;
/* 102 */     if (t instanceof TerrainDiagonal.Diagonalizer) {
/* 103 */       d |= ((TerrainDiagonal.Diagonalizer)t).getDia(tx, ty) ? 256 : 0;
/*     */     }
/*     */     
/* 106 */     d |= ((Terrain.TerrainTile)t).code;
/* 107 */     this.shared.data.set(tx, ty, d);
/*     */     
/* 109 */     placeFixed(tx, ty);
/*     */   }
/*     */   
/*     */   public int getData(int tx, int ty) {
/* 113 */     return this.shared.data.get(tx, ty) >> 8 & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/* 118 */     int d = this.shared.data.get(tx, ty);
/* 119 */     placeRaw(tx, ty);
/* 120 */     this.shared.data.set(tx, ty, d);
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 126 */     int x = i.x();
/* 127 */     int y = i.y();
/* 128 */     int ran = i.ran();
/* 129 */     TDestoryable t = (TDestoryable)get(i.tx(), i.ty());
/* 130 */     t.breakableRes().renderDebris(r, s, x, y, ran, t.resAmount());
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int tx, int ty) {
/* 136 */     return AVAILABILITY.PENALTY2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 141 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniC(int x, int y) {
/* 146 */     return get(x, y).miniC(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 151 */     return get(x, y).miniColorPimped(c, x, y, northern, southern);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Job fixJob(int tx, int ty) {
/* 162 */     return ((TDestoryable)get(tx, ty)).fixJob();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDia(int tx, int ty, boolean dia) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDia(int tx, int ty) {
/* 179 */     return ((this.shared.data.get(tx, ty) >> 8 & 0x1) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile getTerrain(int tx, int ty) {
/* 184 */     return get(tx, ty);
/*     */   }
/*     */   
/*     */   static interface TDestoryable {
/*     */     Job fixJob();
/*     */     
/*     */     int resAmount();
/*     */     
/*     */     RESOURCE breakableRes();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TDestroyed.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */