/*     */ package settlement.room.main.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FResources;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Deleter
/*     */   extends PlacableMulti
/*     */ {
/*  30 */   private static CharSequence ¤¤name = "Dismantle Room";
/*  31 */   private static CharSequence ¤¤desc = "Dismantle room, recovering some of the resources used to build it. Cannot be undone.";
/*     */   static {
/*  33 */     D.ts(Deleter.class);
/*     */   }
/*     */   
/*     */   public Deleter(ROOMS m) {
/*  37 */     super(¤¤name, ¤¤desc, (SPRITES.icons()).m.cancel.resized(32).twin((SPRITE)(UI.icons()).m.ceiling, DIR.NE, 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  42 */     return canRemove(tx, ty) ? null : "";
/*     */   }
/*     */   
/*     */   public static boolean canRemove(int tx, int ty) {
/*  46 */     if ((SETT.ROOMS()).THRONE.is(tx, ty))
/*  47 */       return false; 
/*  48 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  49 */     if (r == null)
/*  50 */       return false; 
/*  51 */     if (r instanceof ArtilleryInstance) {
/*  52 */       ArtilleryInstance i = (ArtilleryInstance)r;
/*  53 */       return (i.army() == GAME.ARMIES().player());
/*     */     } 
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  61 */     if ((SETT.ROOMS()).THRONE.is(tx, ty))
/*     */       return; 
/*  63 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  64 */     if (r == null) {
/*     */       return;
/*     */     }
/*  67 */     if (r instanceof ArtilleryInstance) {
/*  68 */       ArtilleryInstance i = (ArtilleryInstance)r;
/*  69 */       if (i.army() != GAME.ARMIES().player())
/*     */         return; 
/*     */     } 
/*  72 */     boolean rem = (SETT.ROOMS()).construction.isser.is(tx, ty);
/*  73 */     TmpArea ar = r.remove(tx, ty, true, this, false);
/*  74 */     if (!rem)
/*  75 */       ar.setRemoveFloor(); 
/*  76 */     if (ar != null) {
/*  77 */       ar.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canBePlacedAs(PLACER_TYPE t) {
/*  82 */     return !(t != PLACER_TYPE.BRUSH && t != PLACER_TYPE.SQUARE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*  87 */     if ((SETT.ROOMS()).THRONE.is(fromX, fromY)) {
/*  88 */       return false;
/*     */     }
/*  90 */     return ((SETT.ROOMS()).map.is(fromX, fromY) && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*     */   }
/*     */ 
/*     */   
/*  94 */   private static final double[] amountsd = new double[4];
/*  95 */   private static final int[] amountsi = Alloc.ii(4);
/*     */   private static int[] getResources(AREA r, Furnisher furnisher, int upgrade, double degrade) {
/*     */     int i;
/*  98 */     for (i = 0; i < amountsd.length; i++) {
/*  99 */       amountsd[i] = 0.0D;
/* 100 */       amountsi[i] = 0;
/*     */     } 
/* 102 */     for (COORDINATE c : r.body()) {
/*     */       
/* 104 */       if (!r.is(c)) {
/*     */         continue;
/*     */       }
/* 107 */       if ((SETT.ROOMS()).fData.isMaster.is(c)) {
/* 108 */         FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(c);
/* 109 */         for (int j = 0; j < furnisher.resources(); j++) {
/* 110 */           amountsd[j] = amountsd[j] + it.cost2(j, upgrade);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     degrade = CLAMP.d(1.0D - degrade, 0.0D, 1.0D);
/* 116 */     for (i = 0; i < furnisher.resources(); i++) {
/* 117 */       amountsd[i] = amountsd[i] + Math.ceil(r.area() * furnisher.areaCost(i, upgrade));
/* 118 */       double mm = amountsd[i] * 0.75D * degrade;
/* 119 */       amountsi[i] = (int)mm;
/* 120 */       if (amountsd[i] - amountsi[i] > RND.rFloat()) {
/* 121 */         amountsi[i] = amountsi[i] + 1;
/*     */       }
/*     */     } 
/*     */     
/* 125 */     return amountsi;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void scatterMaterials(AREA r, Furnisher furnisher, int upgrade, double degrade) {
/* 130 */     getResources(r, furnisher, upgrade, degrade);
/*     */ 
/*     */     
/* 133 */     int resAll = 0;
/* 134 */     int resPiles = 0;
/* 135 */     for (int i = 0; i < furnisher.resources(); i++) {
/* 136 */       resAll += amountsi[i];
/* 137 */       resPiles = (int)(resPiles + Math.ceil(amountsi[i] / 32.0D));
/*     */     } 
/*     */     
/* 140 */     if (resPiles == 0) {
/*     */       return;
/*     */     }
/* 143 */     double resPerPile = resAll / r.area();
/* 144 */     double am = 0.0D;
/*     */     
/* 146 */     for (COORDINATE c : r.body()) {
/* 147 */       if (!r.is(c))
/*     */         continue; 
/* 149 */       am += resPerPile;
/* 150 */       if (am >= 1.0D) {
/*     */         
/* 152 */         int di = RND.rInt(furnisher.resources());
/* 153 */         for (int j = 0; j < furnisher.resources() && am >= 1.0D; j++) {
/* 154 */           int ri = (di + j) % furnisher.resources();
/* 155 */           if (amountsi[ri] > 0) {
/*     */             
/* 157 */             int a = CLAMP.i(amountsi[ri], 0, (int)am);
/* 158 */             (SETT.THINGS()).resources.create(c, furnisher.resource(ri), a);
/* 159 */             GAME.player().res().inc(furnisher.resource(ri), FResources.RTYPE.CONSTRUCTION, a);
/* 160 */             am -= a;
/* 161 */             amountsi[ri] = amountsi[ri] - a;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\Deleter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */