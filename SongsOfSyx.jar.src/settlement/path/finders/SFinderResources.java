/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResGroup;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingsResources;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SFinderResources
/*     */ {
/*  36 */   public final Normal normal = new Normal();
/*  37 */   public final Scattered scattered = new Scattered();
/*     */   
/*  39 */   private final RBIT.RBITImp bscattered = new RBIT.RBITImp();
/*  40 */   private final RBIT.RBITImp bstored = new RBIT.RBITImp();
/*  41 */   private final RBIT.RBITImp bprio = new RBIT.RBITImp();
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
/*     */   private SFINDER finder;
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
/*     */   public boolean has(int sx, int sy, RBIT bits) {
/* 131 */     return has(sx, sy, bits, bits, bits);
/*     */   }
/*     */   
/*     */   public boolean has(int sx, int sy, RBIT scattered, RBIT stored, RBIT prio) {
/* 135 */     return !(!(SETT.PATH()).comps.data.resScattered.has(sx, sy, scattered) && 
/* 136 */       !(SETT.PATH()).comps.data.resCrate.has(sx, sy, stored) && !(SETT.PATH()).comps.data.resPriority.has(sx, sy, prio));
/*     */   }
/*     */   
/*     */   public RESOURCE find(RBIT scattered, RBIT stored, RBIT prio, COORDINATE start, SPath path, int maxdistance) {
/* 140 */     return find(scattered, stored, prio, start.x(), start.y(), path, maxdistance);
/*     */   }
/*     */   
/*     */   public RESOURCE find(RBIT bits, COORDINATE start, SPath path, int maxdistance) {
/* 144 */     return find(bits, start.x(), start.y(), path, maxdistance);
/*     */   }
/*     */   
/*     */   public RESOURCE find(RBIT bits, int sx, int sy, SPath path, int maxdistance) {
/* 148 */     return find(bits, bits, bits, sx, sy, path, maxdistance);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE find(RBIT scattered, RBIT stored, RBIT prio, int sx, int sy, SPath path, int maxdistance) {
/* 153 */     if (has(sx, sy, scattered, stored, prio)) {
/* 154 */       this.bscattered.clearSet(scattered);
/* 155 */       this.bstored.clearSet(stored);
/* 156 */       this.bprio.clearSet(prio);
/*     */       
/* 158 */       if (path.request(sx, sy, this.finder, maxdistance)) {
/* 159 */         RESOURCE_TILE t = RESOURCE_TILE.GETTER.reservable((RBIT)this.bscattered, (RBIT)this.bstored, (RBIT)this.bprio, path.destX(), path.destY());
/* 160 */         t.findableReserve();
/* 161 */         return t.resource();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 166 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE find(RBIT scattered, RBIT stored, RBIT prio, RoomInstance ins, int maxdistance) {
/* 171 */     if (has(ins.mX(), ins.mY(), scattered, stored, prio)) {
/* 172 */       this.bscattered.clearSet(scattered);
/* 173 */       this.bstored.clearSet(stored);
/* 174 */       this.bprio.clearSet(prio);
/*     */       
/* 176 */       COORDINATE r = (SETT.PATH()).finders.finder().findDest(ins, this.finder, maxdistance);
/* 177 */       if (r != null) {
/* 178 */         return RESOURCE_TILE.GETTER.reservable((RBIT)this.bscattered, (RBIT)this.bstored, (RBIT)this.bprio, r.x(), r.y());
/*     */       }
/*     */     } 
/*     */     
/* 182 */     return null;
/*     */   }
/*     */   
/* 185 */   SFinderResources() { this.finder = new SFINDER() { public void exe() { for (COORDINATE c : new Rec(SETT.TILE_BOUNDS)) { do {  } while (unres(c)); Room room = (SETT.ROOMS()).map.get(c.x(), c.y()); if (room != null) { RESOURCE_TILE res = room.resourceTile(c.x(), c.y()); while (res != null && res.findableReservedIs() && res.resource() != null)
/*     */                 res.findableReserveCancel();  }
/*     */              }
/*     */            }
/* 189 */         public boolean isInComponent(SComponent c, double distance) { return !(!(SETT.PATH()).comps.data.resScattered.has(c, (RBIT)SFinderResources.this.bscattered) && 
/* 190 */             !(SETT.PATH()).comps.data.resCrate.has(c, (RBIT)SFinderResources.this.bstored) && !(SETT.PATH()).comps.data.resPriority.has(c, (RBIT)SFinderResources.this.bprio)); } private boolean unres(COORDINATE c) { for (THINGS.Thing t : SETT.THINGS().get(c.x(), c.y())) { if (t instanceof ThingsResources.ScatteredResource) { ThingsResources.ScatteredResource sc = (ThingsResources.ScatteredResource)t; if (sc.findableReservedIs() && sc.resource() != null) { sc.findableReserveCancel(); return true; }  }  }  return false; }
/*     */       }); IDebugPanelSett.add((PLACABLE)new PlacableSimpleTile("find resource") {
/*     */         RBIT.RBITImp bits = new RBIT.RBITImp(); LIST<CLICKABLE> li; }; IDebugPanelSett.add("Unreserve everything", new ACTION() {
/*     */           public void place(int tx, int ty) { SPath p = new SPath(); RESOURCE res = SFinderResources.this.find((RBIT)this.bits, (COORDINATE)new Coo(tx, ty), p, 250); if (res == null) { LOG.ln("nope"); }
/*     */             else { LOG.ln("" + p.destX() + " " + p.destX()); RESOURCE_TILE.GETTER.reserved(res, p.destX(), p.destY()); }
/* 195 */              } public CharSequence isPlacable(int tx, int ty) { return null; } public boolean isTile(int tx, int ty, int tileNr) { return (RESOURCE_TILE.GETTER.reservable((RBIT)SFinderResources.this.bscattered, (RBIT)SFinderResources.this.bstored, (RBIT)SFinderResources.this.bprio, tx, ty) != null); } public LIST<CLICKABLE> getAdditionalButt() {
/*     */             return this.li;
/*     */           }
/*     */         }); }
/*     */    public int reserveExtra(boolean stored, boolean fetch, RESOURCE r, int tx, int ty, int amount) {
/* 200 */     return RESOURCE_TILE.GETTER.reserve(stored, fetch, r, tx, ty, amount);
/*     */   }
/*     */   
/*     */   public boolean isReservedAndAvailable(RESOURCE r, int x, int y) {
/* 204 */     return (RESOURCE_TILE.GETTER.reserved(r, x, y) != null);
/*     */   }
/*     */   
/*     */   public final int pickup(RESOURCE r, int tx, int ty, int amount) {
/* 208 */     return RESOURCE_TILE.GETTER.pickup(r, tx, ty, amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void unreserve(RESOURCE r, int tx, int ty, int amount) {
/* 213 */     RESOURCE_TILE.GETTER.unreserve(r, tx, ty, amount);
/*     */   }
/*     */   
/*     */   public void reportPresence(RESOURCE_TILE r) {
/* 217 */     if (!r.isFindable())
/*     */       return; 
/* 219 */     if (r.isPrio()) {
/* 220 */       (SETT.PATH()).comps.data.resPriority.reportPresence(r.x(), r.y(), r.resource());
/* 221 */     } else if (r.isStorage()) {
/* 222 */       (SETT.PATH()).comps.data.resCrate.reportPresence(r.x(), r.y(), r.resource());
/*     */     } else {
/* 224 */       (SETT.PATH()).comps.data.resScattered.reportPresence(r.x(), r.y(), r.resource());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void reportAbsence(RESOURCE_TILE r) {
/* 230 */     if (!r.isFindable())
/*     */       return; 
/* 232 */     if (r.isPrio()) {
/* 233 */       (SETT.PATH()).comps.data.resPriority.reportAbsence(r.x(), r.y(), r.resource());
/* 234 */     } else if (r.isStorage()) {
/* 235 */       (SETT.PATH()).comps.data.resCrate.reportAbsence(r.x(), r.y(), r.resource());
/*     */     } else {
/* 237 */       (SETT.PATH()).comps.data.resScattered.reportAbsence(r.x(), r.y(), r.resource());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class Normal
/*     */   {
/*     */     public boolean has(int sx, int sy, RESOURCE r) {
/* 249 */       return has(sx, sy, r.bit);
/*     */     }
/*     */     
/*     */     public boolean has(int sx, int sy, ResGroup<?> group) {
/* 253 */       return has(sx, sy, group.mask);
/*     */     }
/*     */     
/*     */     public boolean has(int sx, int sy, RBIT mask) {
/* 257 */       return SFinderResources.this.has(sx, sy, mask, mask, mask);
/*     */     }
/*     */     
/*     */     public boolean reserve(COORDINATE start, RESOURCE r, SPath path, int maxdistance) {
/* 261 */       return (reserve(start, r.bit, path, maxdistance) != null);
/*     */     }
/*     */     
/*     */     public RESOURCE reserve(COORDINATE start, RBIT mask, SPath path, int maxdistance) {
/* 265 */       return SFinderResources.this.find(mask, mask, mask, start, path, maxdistance);
/*     */     }
/*     */     
/*     */     public int reserveExtra(RESOURCE r, int x, int y, int amount) {
/* 269 */       return SFinderResources.this.reserveExtra(true, true, r, x, y, amount);
/*     */     }
/*     */     
/*     */     public boolean has(RESOURCE r) {
/* 273 */       return has(THRONE.coo().x(), THRONE.coo().y(), r);
/*     */     }
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
/*     */   public class Scattered
/*     */   {
/*     */     public boolean has(RESOURCE r) {
/* 290 */       return has(THRONE.coo().x(), THRONE.coo().y(), r);
/*     */     }
/*     */     
/*     */     public boolean has(int sx, int sy, RESOURCE r) {
/* 294 */       return has(sx, sy, r.bit);
/*     */     }
/*     */     
/*     */     public boolean has(int sx, int sy, RBIT mask) {
/* 298 */       return SFinderResources.this.has(sx, sy, mask, RBIT.NONE, RBIT.NONE);
/*     */     }
/*     */     
/*     */     public boolean reserve(COORDINATE start, RESOURCE r, SPath path, int maxdistance) {
/* 302 */       return (reserve(start, r.bit, path, maxdistance) != null);
/*     */     }
/*     */     
/*     */     public RESOURCE reserve(COORDINATE start, RBIT resMask, SPath path, int maxdistance) {
/* 306 */       return reserve(start.x(), start.y(), resMask, path, maxdistance);
/*     */     }
/*     */     
/*     */     public RESOURCE reserve(int sx, int sy, RBIT resMask, SPath path, int maxdistance) {
/* 310 */       return SFinderResources.this.find(resMask, RBIT.NONE, RBIT.NONE, sx, sy, path, maxdistance);
/*     */     }
/*     */     
/*     */     public int reserveExtra(RESOURCE r, int x, int y, int amount) {
/* 314 */       return SFinderResources.this.reserveExtra(false, false, r, x, y, amount);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResources.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */