/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
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
/*     */ public abstract class Tree
/*     */   extends Terrain.TerrainTile
/*     */ {
/* 165 */   private final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/* 167 */       private SoundRace sound = AUDIO.race("CLEAR_TREE");
/*     */ 
/*     */ 
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty) {
/* 172 */         int a = (TForest.Tree.access$0(TForest.Tree.this)).amount.get(tx, ty);
/* 173 */         if (a > 0) {
/*     */           
/* 175 */           if (a == 1) {
/* 176 */             (SETT.TERRAIN()).DECOR_WOOD.placeFixed(tx, ty);
/* 177 */             return RESOURCES.WOOD();
/*     */           } 
/* 179 */           (TForest.Tree.access$0(TForest.Tree.this)).amount.increment(tx, ty, -1);
/*     */         } else {
/* 181 */           GAME.Notify("what??? " + tx + " " + ty + " " + a);
/*     */         } 
/*     */         
/* 184 */         (TForest.Tree.access$0(TForest.Tree.this)).clearAm += 0.25D;
/* 185 */         if ((TForest.Tree.access$0(TForest.Tree.this)).clearAm >= 1.0D) {
/* 186 */           return RESOURCES.WOOD();
/*     */         }
/* 188 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/* 193 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/* 198 */         int a = (TForest.Tree.access$0(TForest.Tree.this)).amount.get(tx, ty);
/* 199 */         (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/* 200 */         return a;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/* 205 */         return this.sound;
/*     */       }
/*     */ 
/*     */       
/*     */       public double strength() {
/* 210 */         return super.strength() * 4.0D;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean place(int tx, int ty) {
/* 219 */     TForest.this.isTree(tx, ty);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     if (!this.shared.TREES.BIG.tryPlace(tx, ty) && 
/* 227 */       !this.shared.TREES.MEDIUM.tryPlace(tx, ty))
/* 228 */       this.shared.TREES.SMALL.tryPlace(tx, ty); 
/* 229 */     TForest.this.amount.set(tx, ty, 4);
/*     */     
/* 231 */     return false;
/*     */   }
/*     */   
/*     */   protected Tree(Terrain shared, int i) {
/* 235 */     super("TREE_SIZE_" + i, shared, TForest.¤¤name, (SPRITE)(SPRITES.icons()).m.cancel, shared.colors.minimap.tree);
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/* 240 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 245 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void unplace(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box, int tx, int ty) {
/* 255 */     box.add((SPRITE)RESOURCES.WOOD().icon());
/* 256 */     box.textLL((RESOURCES.WOOD()).name);
/* 257 */     box.tab(6);
/* 258 */     box.add((SPRITE)GFORMAT.i(box.text(), TForest.this.amount.get(tx, ty)));
/*     */   }
/*     */ 
/*     */   
/*     */   public int miniDepth() {
/* 263 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public TERRAIN terrain(int tx, int ty) {
/* 268 */     return TERRAINS.FOREST();
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightStart(int tx, int ty) {
/* 273 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightEnd(int tx, int ty) {
/* 278 */     return 4;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TForest$Tree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */