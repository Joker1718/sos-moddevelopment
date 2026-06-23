/*     */ package settlement.room.military.artillery;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.thing.projectiles.Projectile;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import view.tool.PlacableFixed;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ROOM_ARTILLERY
/*     */   extends RoomBlueprintIns<ArtilleryInstance>
/*     */ {
/*     */   public static final String type = "ARTILLERY";
/*     */   final Constructor constructor;
/*     */   public final RESOURCE PROJECTILE;
/*     */   private volatile boolean threadLock;
/*  37 */   private final ArrayListResize<ArtilleryInstance> threadSafe = new ArrayListResize(256);
/*     */   
/*     */   public final Projectile projectile;
/*  40 */   final Service service = new Service(this);
/*  41 */   private double ref = 0.0D;
/*     */   
/*  43 */   private double upI = 0.0D;
/*     */   
/*  45 */   private static CharSequence ¤¤control = "¤Control artillery piece in the battle view.";
/*     */   
/*  47 */   public final int services = 6; public PlacableFixed eplacer;
/*     */   
/*     */   static {
/*  50 */     D.ts(ROOM_ARTILLERY.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_ARTILLERY(int ti, RoomInitData data, String key, RoomCategorySub cat) throws IOException {
/*  56 */     super(ti, data, key, cat);
/*     */     
/*  58 */     this.constructor = new Constructor(data, this)
/*     */       {
/*     */         public Room create(TmpArea area, RoomInit init)
/*     */         {
/*  62 */           return (Room)new ArtilleryInstance(ROOM_ARTILLERY.this, area, init);
/*     */         }
/*     */       };
/*     */     
/*  66 */     pushBo(data.data(), "ARTILLERY", true);
/*  67 */     this.PROJECTILE = (RESOURCE)RESOURCES.map().read("PROJECTILE_RESOURCE", data.data());
/*  68 */     this.projectile = (Projectile)new Projectile.ProjectileImp(data.data(), "ROOM_" + key);
/*  69 */     this.eplacer = new Placer(this, data.m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter f) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearP() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  90 */     this.upI -= ds;
/*  91 */     if (this.upI < 0.0D) {
/*  92 */       lock();
/*  93 */       this.threadSafe.clearSoft();
/*  94 */       for (int k = 0; k < instancesSize(); k++)
/*  95 */         this.threadSafe.add(getInstance(k)); 
/*  96 */       this.threadLock = false;
/*  97 */       this.ref = bonus().get((BOOSTABLE_O)HCLASS_RACE.clP(null, null)) / bonus().max(HCLASS_RACE.class);
/*  98 */       this.upI += 3.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderFindable service(int tx, int ty) {
/* 105 */     ArtilleryInstance ins = (ArtilleryInstance)get(tx, ty);
/* 106 */     if (ins != null)
/* 107 */       return (SFinderFindable)(SETT.PATH()).finders.manning(ins.army()); 
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 113 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 118 */     mm.add(new UIRoomModule()
/*     */         {
/*     */           public void hover(GBox box, Room i, int rx, int ry) {
/* 121 */             ArtilleryInstance ins = (ArtilleryInstance)i;
/* 122 */             Hoverer.hover(box, ins);
/* 123 */             if (ins.army() == GAME.ARMIES().player()) {
/* 124 */               box.NL();
/* 125 */               box.text(ROOM_ARTILLERY.¤¤control);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public double ref() {
/* 133 */     return this.ref;
/*     */   } private synchronized void lock() {
/*     */     do {
/*     */     
/* 137 */     } while (this.threadLock);
/*     */     
/* 139 */     this.threadLock = true;
/*     */   }
/*     */   
/*     */   public void threadInstances(LISTE<ArtilleryInstance> res) {
/* 143 */     lock();
/* 144 */     res.add((Iterable)this.threadSafe);
/* 145 */     this.threadLock = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\artillery\ROOM_ARTILLERY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */