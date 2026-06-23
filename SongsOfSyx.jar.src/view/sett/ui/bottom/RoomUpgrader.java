/*     */ package view.sett.ui.bottom;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.Lock;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ public final class RoomUpgrader
/*     */   extends PlacableMulti {
/*  32 */   private static CharSequence ¤¤name = "Room upgrade";
/*  33 */   private static CharSequence ¤¤desc = "Upgrade the rooms that can be upgraded.";
/*     */   
/*  35 */   private static CharSequence ¤¤UPGRADE_MAX_REACHED = "¤Maximally Upgraded.";
/*  36 */   private static CharSequence ¤¤RESOURCES = "¤Not enough resources.";
/*  37 */   private static CharSequence ¤¤noSelect = "¤No rooms selected that can be upgraded.";
/*  38 */   private int[] resources = Alloc.ii(RESOURCES.ALL().size());
/*     */   
/*     */   static {
/*  41 */     D.ts(RoomUpgrader.class);
/*     */   }
/*     */   private CharSequence error;
/*  44 */   private final double iunprocessed = -2.0D;
/*  45 */   private final double ierror = -1.0D;
/*  46 */   private final double iok = 0.0D;
/*     */   private boolean any = false;
/*     */   
/*     */   public RoomUpgrader() {
/*  50 */     super(¤¤name, ¤¤desc, (SPRITE)(UI.icons()).l.upgrade);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  55 */     Room rr = (SETT.ROOMS()).map.get(tx, ty);
/*  56 */     if (rr == null)
/*  57 */       return E; 
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(AREA area, PLACER_TYPE type) {
/*  64 */     for (COORDINATE c : area.body()) {
/*  65 */       int tx = c.x();
/*  66 */       int ty = c.y();
/*  67 */       if (area.is(tx, ty)) {
/*  68 */         Room rr = (SETT.ROOMS()).map.get(tx, ty);
/*  69 */         if (rr == null)
/*     */           continue; 
/*  71 */         GUTIL.flooder().setValue2(rr.mX(tx, ty), rr.mY(tx, ty), -2.0D);
/*     */       } 
/*     */     } 
/*  74 */     Arrays.fill(this.resources, 0);
/*  75 */     this.error = null;
/*  76 */     this.any = false;
/*  77 */     boolean room = false;
/*     */     
/*  79 */     for (COORDINATE c : area.body()) {
/*  80 */       if (area.is(c)) {
/*  81 */         int tx = c.x();
/*  82 */         int ty = c.y();
/*  83 */         Room rr = (SETT.ROOMS()).map.get(tx, ty);
/*  84 */         if (rr == null)
/*     */           continue; 
/*  86 */         int mx = rr.mX(tx, ty);
/*  87 */         int my = rr.mY(tx, ty);
/*     */         
/*  89 */         if (GUTIL.flooder().getValue2(mx, my) != -2.0D)
/*     */           continue; 
/*  91 */         GUTIL.flooder().setValue2(mx, my, -1.0D);
/*     */         
/*  93 */         CharSequence e = canUpgrade(rr, mx, my);
/*  94 */         if (e != null) {
/*  95 */           if (this.error == null) {
/*  96 */             this.error = e;
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 101 */         boolean can = true;
/* 102 */         room = true;
/* 103 */         for (int ri = 0; ri < resources(rr); ri++) {
/*     */           
/* 105 */           int am = resAm(rr, tx, ty, ri);
/* 106 */           RESOURCE res = res(rr, ri);
/* 107 */           this.resources[res.index()] = this.resources[res.index()] + am;
/*     */           
/* 109 */           if (((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(res) < this.resources[res.index()]) {
/* 110 */             can = false;
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 118 */         if (!can) {
/* 119 */           if (this.error == null) {
/* 120 */             this.error = ¤¤RESOURCES;
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 126 */         this.any = true;
/* 127 */         GUTIL.flooder().setValue2(mx, my, 0.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 134 */     if (!room && this.error == null) {
/* 135 */       this.error = ¤¤noSelect;
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */   
/*     */   private RESOURCE res(Room r, int ri) {
/* 141 */     return r.constructor().resource(ri);
/*     */   }
/*     */   
/*     */   private int resources(Room r) {
/* 145 */     return r.constructor().resources();
/*     */   }
/*     */   
/*     */   private int resAm(Room rr, int tx, int ty, int ri) {
/* 149 */     int current = rr.upgrade(tx, ty);
/* 150 */     return rr.resAmount(ri, current + 1) - rr.resAmount(ri, current);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/* 157 */     isPlacable = false;
/* 158 */     areaIsPlacable = true;
/* 159 */     Room rr = (SETT.ROOMS()).map.get(tx, ty);
/* 160 */     if (rr != null) {
/* 161 */       int mx = rr.mX(tx, ty);
/* 162 */       int my = rr.mY(tx, ty);
/* 163 */       if (GUTIL.flooder().getValue2(mx, my) == 0.0D) {
/* 164 */         isPlacable = true;
/* 165 */       } else if (this.error == ¤¤noSelect) {
/* 166 */         areaIsPlacable = false;
/*     */       } 
/*     */     } 
/* 169 */     if (!isPlacable) {
/* 170 */       (GCOLOR.MAP()).BAD.bind();
/* 171 */     } else if (!areaIsPlacable) {
/* 172 */       (GCOLOR.MAP()).SOSO.bind();
/*     */     } else {
/* 174 */       (GCOLOR.MAP()).BEST.bind();
/*     */     } 
/* 176 */     super.renderPlaceHolder(r, mask, x, y, tx, ty, area, type, isPlacable, areaIsPlacable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox box, int oktiles, AREA area) {
/* 181 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 182 */       if (this.resources[res.index()] > 0) {
/* 183 */         box.add((SPRITE)res.icon());
/* 184 */         box.add((SPRITE)GFORMAT.iofk(box.text(), this.resources[res.index()], ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(res)));
/* 185 */         box.NL();
/*     */       } 
/*     */     } 
/* 188 */     if (!this.any) {
/* 189 */       box.error(this.error);
/* 190 */     } else if (this.error != null) {
/* 191 */       box.add((SPRITE)box.text().warnify().add(this.error));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRegardless(GameWindow window, AREA selected) {
/* 197 */     Arrays.fill(this.resources, 0);
/* 198 */     super.updateRegardless(window, selected);
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 203 */     Room rr = (SETT.ROOMS()).map.get(tx, ty);
/* 204 */     if (rr == null)
/*     */       return; 
/* 206 */     if (rr.mX(tx, ty) != tx || rr.mY(tx, ty) != ty)
/*     */       return; 
/* 208 */     if (canUpgrade(rr, tx, ty) != null) {
/*     */       return;
/*     */     }
/* 211 */     int current = rr.upgrade(tx, ty);
/*     */     int ri;
/* 213 */     for (ri = 0; ri < resources(rr); ri++) {
/*     */       
/* 215 */       int am = resAm(rr, tx, ty, ri);
/* 216 */       RESOURCE res = res(rr, ri);
/*     */       
/* 218 */       if (((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(res) < am) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 224 */     for (ri = 0; ri < resources(rr); ri++) {
/*     */       
/* 226 */       int am = resAm(rr, tx, ty, ri);
/* 227 */       RESOURCE res = res(rr, ri);
/*     */       
/* 229 */       res.remove(am, FResources.RTYPE.CONSTRUCTION);
/*     */     } 
/*     */     
/* 232 */     rr.upgradeSet(tx, ty, current + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CharSequence canUpgrade(Room rr, int tx, int ty) {
/* 239 */     if (!(rr.blueprint() instanceof RoomBlueprintImp))
/* 240 */       return E; 
/* 241 */     RoomBlueprintImp b = (RoomBlueprintImp)rr.blueprint();
/* 242 */     if (b.upgrades().max() == 0)
/* 243 */       return ¤¤UPGRADE_MAX_REACHED; 
/* 244 */     int current = rr.upgrade(tx, ty);
/* 245 */     if (current >= b.upgrades().max())
/* 246 */       return ¤¤UPGRADE_MAX_REACHED; 
/* 247 */     for (Lock<Faction> r : (Iterable<Lock<Faction>>)b.upgrades().requires(current + 1).all()) {
/* 248 */       if (!r.unlocker.inUnlocked(FACTIONS.player())) {
/* 249 */         return (CharSequence)Str.TMP.clear().add(Dic.¤¤Requires).add(':').s().add(r.unlocker.name);
/*     */       }
/*     */     } 
/* 252 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 257 */     Room rr = (SETT.ROOMS()).map.get(fromX, fromY);
/* 258 */     if (rr == null)
/* 259 */       return false; 
/* 260 */     if (!rr.isSame(fromX, fromY, toX, toY))
/* 261 */       return false; 
/* 262 */     if (rr.blueprint() instanceof RoomBlueprintImp) {
/* 263 */       RoomBlueprintImp b = (RoomBlueprintImp)rr.blueprint();
/* 264 */       if (b.upgrades().max() == 0)
/* 265 */         return false; 
/* 266 */       int current = rr.upgrade(fromX, fromY);
/* 267 */       if (current >= b.upgrades().max())
/* 268 */         return false; 
/* 269 */       return true;
/*     */     } 
/* 271 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\RoomUpgrader.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */