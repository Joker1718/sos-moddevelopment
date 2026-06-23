/*     */ package settlement.room.infra.monument;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.race.bio.Opinion;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomSingleton;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsAccess;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public abstract class ROOM_MONUMENT extends RoomBlueprintImp {
/*  45 */   public final Bitsmap2D mapData = new Bitsmap2D(0, 4, (DIMENSION)SETT.TILE_BOUNDS);
/*  46 */   public final Bitsmap2D mapUpgrade = new Bitsmap2D(0, 2, (DIMENSION)SETT.TILE_BOUNDS);
/*     */   
/*     */   final AVAILABILITY avail;
/*     */   
/*     */   private final int MAX_VALUE;
/*     */   protected final RoomSingleton instance;
/*     */   private int area;
/*     */   private int degrade;
/*     */   private int upgrade;
/*     */   public final StatStanding.StandingDef defaultStanding;
/*     */   public final StatStanding.StandingDef defaultStandingUp;
/*     */   public final Opinion opinion;
/*     */   public final int monumentIndex;
/*     */   public final BoostSpecs boosts;
/*  60 */   private static int ii = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] radius;
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_DOUBLE envValue;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ROOM_MONUMENT(RoomInitData init, final int tindex, String key, RoomCategorySub cat) throws IOException {
/*  74 */     super(init, tindex, key, cat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     this
/* 279 */       .radius = new int[] { 5, 10, 15 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     this.envValue = new MAP_DOUBLE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 296 */           return ROOM_MONUMENT.this.mapData.get(tx, ty) / ROOM_MONUMENT.this.MAX_VALUE;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 301 */           return ROOM_MONUMENT.this.mapData.get(tile) / ROOM_MONUMENT.this.MAX_VALUE;
/*     */         }
/*     */       };
/*     */     this.instance = new Instance(init.m, (RoomBlueprint)this);
/*     */     this.defaultStanding = new StatStanding.StandingDef(init.data());
/*     */     if (init.data().has("STANDING_UPGRADE")) {
/*     */       this.defaultStandingUp = new StatStanding.StandingDef(init.data().json("STANDING_UPGRADE"));
/*     */     } else {
/*     */       this.defaultStandingUp = null;
/*     */     } 
/*     */     this.opinion = new Opinion();
/*     */     this.opinion.read(init.text());
/*     */     this.monumentIndex = ii++;
/*     */     this.MAX_VALUE = init.data().i("MAX_VALUE");
/*     */     this.boosts = new BoostSpecs(this.info.names, (SPRITE)this.icon, false);
/*     */     this.avail = init.data().bool("SOLID", true) ? AVAILABILITY.SOLID : AVAILABILITY.ROOM;
/*     */     BValue v = new BValue() {
/*     */         public double vGet(FactionNPC f) {
/*     */           return 0.0D;
/*     */         }
/*     */         
/*     */         public double vGet(Player f) {
/*     */           return vGet(HCLASS_RACE.clP());
/*     */         }
/*     */         
/*     */         public double vGet(HCLASS_RACE t) {
/*     */           return ((StatsAccess.StatMonument)(STATS.ACCESS()).MONUMENTS.ALL().get(tindex)).data(t.cl).getD(t.race);
/*     */         }
/*     */         
/*     */         public double vGet(Div div) {
/*     */           return ((StatsAccess.StatMonument)(STATS.ACCESS()).MONUMENTS.ALL().get(tindex)).div().getD(div);
/*     */         }
/*     */         
/*     */         public double vGet(Induvidual indu) {
/*     */           return ((StatsAccess.StatMonument)(STATS.ACCESS()).MONUMENTS.ALL().get(tindex)).indu().getD(indu);
/*     */         }
/*     */         
/*     */         public double vGet(Region reg) {
/*     */           return vGet(reg.faction());
/*     */         }
/*     */       };
/*     */     this.boosts.read("FULFILLMENT_BONUS", init.data(), v);
/*     */   }
/*     */   
/*     */   protected void save(FilePutter f) {
/*     */     f.i(this.area);
/*     */     f.i(this.degrade);
/*     */     f.i(this.upgrade);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/*     */     this.area = f.i();
/*     */     this.degrade = f.i();
/*     */     this.upgrade = f.i();
/*     */   }
/*     */   
/*     */   protected void clear() {
/*     */     this.area = 0;
/*     */     this.degrade = 0;
/*     */     this.upgrade = 0;
/*     */   }
/*     */   
/*     */   public int area() {
/*     */     return this.area;
/*     */   }
/*     */   
/*     */   public double degrade() {
/*     */     if (this.area == 0)
/*     */       return 0.0D; 
/*     */     return this.degrade / this.area;
/*     */   }
/*     */   
/*     */   public double upgrade() {
/*     */     if (this.area == 0)
/*     */       return 0.0D; 
/*     */     if (upgrades().max() == 0)
/*     */       return 1.0D; 
/*     */     return (this.upgrade + this.area) / (this.area * (upgrades().max() + 1));
/*     */   }
/*     */   
/*     */   public Room get(int tx, int ty) {
/*     */     if ((SETT.ROOMS()).map.get(tx, ty) == this.instance)
/*     */       return (Room)this.instance; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected void update(double ds) {}
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*     */     return null;
/*     */   }
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*     */     mm.add(new UIRoomModule() {
/*     */           public void hover(GBox box, Room room, int rx, int ry) {
/*     */             box.NL();
/*     */             if (ROOM_MONUMENT.this.upgrades().max() > 0) {
/*     */               box.NL();
/*     */               box.text(Dic.¤¤Upgrade);
/*     */               box.tab(6);
/*     */               box.add((SPRITE)GFORMAT.iofkInv(box.text(), room.upgrade(rx, ry), ROOM_MONUMENT.this.upgrades().max()));
/*     */               box.NL();
/*     */             } 
/*     */             box.text(Dic.¤¤Degrade);
/*     */             box.tab(6);
/*     */             box.add((SPRITE)GFORMAT.percInv(box.text(), room.getDegrade(rx, ry)));
/*     */             box.NL();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   static final class Instance extends RoomSingleton {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     Instance(ROOMS m, RoomBlueprint p) {
/*     */       super(m, p);
/*     */     }
/*     */     
/*     */     protected Object readResolve() {
/*     */       return (blueprintI()).instance;
/*     */     }
/*     */     
/*     */     public ROOM_MONUMENT blueprintI() {
/*     */       return (ROOM_MONUMENT)blueprint();
/*     */     }
/*     */     
/*     */     protected void addAction(ROOMA ins) {
/*     */       (blueprintI()).area += ins.area();
/*     */       (blueprintI()).area = CLAMP.i((blueprintI()).area, 0, SETT.TAREA);
/*     */       (blueprintI()).degrade = (int)((blueprintI()).degrade + ins.area() * getDegrade(ins.mX(), ins.mY()));
/*     */       (blueprintI()).upgrade += ins.area() * upgrade(ins.mX(), ins.mY());
/*     */     }
/*     */     
/*     */     protected void removeAction(ROOMA ins) {
/*     */       (blueprintI()).area -= ins.area();
/*     */       (blueprintI()).area = CLAMP.i((blueprintI()).area, 0, SETT.TAREA);
/*     */       (blueprintI()).degrade = (int)((blueprintI()).degrade - ins.area() * getDegrade(ins.mX(), ins.mY()));
/*     */       (blueprintI()).upgrade -= ins.area() * upgrade(ins.mX(), ins.mY());
/*     */       super.removeAction(ins);
/*     */     }
/*     */     
/*     */     protected void degradeChange(int mx, int my, double oldD, double newD, boolean realDegradeChange) {
/*     */       (blueprintI()).degrade = (int)((blueprintI()).degrade - area(mx, my) * oldD);
/*     */       super.degradeChange(mx, my, oldD, newD, realDegradeChange);
/*     */       (blueprintI()).degrade = (int)((blueprintI()).degrade + area(mx, my) * oldD);
/*     */       if (realDegradeChange)
/*     */         (SETT.ENV()).map.MONUMENT.changeDegrade(mx, my); 
/*     */     }
/*     */     
/*     */     public int upgrade(int tx, int ty) {
/*     */       return CLAMP.i((SETT.ROOMS()).extraBit.get(mX(tx, ty), mY(tx, ty)), 0, blueprintI().upgrades().max());
/*     */     }
/*     */     
/*     */     public void upgradeSet(int tx, int ty, int upgrade) {
/*     */       if (upgrade == upgrade(tx, ty))
/*     */         return; 
/*     */       (blueprintI()).upgrade -= area(tx, ty) * upgrade(tx, ty);
/*     */       int up = CLAMP.i(upgrade, 0, blueprintI().upgrades().max());
/*     */       (SETT.ROOMS()).extraBit.set(tx, ty, up);
/*     */       (blueprintI()).upgrade += area(tx, ty) * upgrade(tx, ty);
/*     */       ROOMA a = (ROOMA)(SETT.ROOMS()).map.rooma.get(tx, ty);
/*     */       for (COORDINATE c : a.body()) {
/*     */         if (a.is(c))
/*     */           SETT.MAINTENANCE().setChanged(c.x(), c.y()); 
/*     */       } 
/*     */       (SETT.ENV()).map.MONUMENT.changeUpgrade(tx, ty);
/*     */     }
/*     */   }
/*     */   
/*     */   public double radius(FurnisherItem it) {
/*     */     if (it == null)
/*     */       return 0.0D; 
/*     */     return this.radius[it.width() - 1];
/*     */   }
/*     */   
/*     */   public int maxEnv() {
/*     */     return this.MAX_VALUE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\ROOM_MONUMENT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */