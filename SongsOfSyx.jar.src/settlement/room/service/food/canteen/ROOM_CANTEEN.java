/*     */ package settlement.room.service.food.canteen;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FResources;
/*     */ import init.resources.Meal;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_CANTEEN
/*     */   extends RoomBlueprintIns<CanteenInstance> implements ROOM_EMPLOY_AUTO, RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER, INDUSTRY_HASER {
/*     */   final Constructor constructor;
/*  39 */   final long[] amounts = new long[RESOURCES.EDI().all().size()]; public final Industry industryFuel; final RoomServiceAccess service;
/*     */   long total;
/*  41 */   final SService food = new SService(this);
/*  42 */   final SWork job = new SWork(this);
/*  43 */   final SChair chair = new SChair(this);
/*     */   
/*     */   final LIST<Industry> indus;
/*     */   
/*     */   public ROOM_CANTEEN(String key, int index, RoomInitData data, RoomCategorySub cat) throws IOException {
/*  48 */     super(index, data, key, cat);
/*     */     
/*  50 */     this.constructor = new Constructor(this, data);
/*  51 */     this.industryFuel = new Industry((RoomBlueprintImp)this, data.data(), null);
/*  52 */     this.service = new RoomServiceAccess((RoomBlueprintImp)this, data, (NEED)(NEEDS.TYPES()).HUNGER)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  56 */           return ROOM_CANTEEN.this.food.get(tx, ty);
/*     */         }
/*     */       };
/*  59 */     employment().countInputSet();
/*  60 */     this.indus = (LIST<Industry>)new ArrayList(this.industryFuel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  73 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  78 */     return this.service.finder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  86 */     this.industryFuel.save(saveFile);
/*  87 */     this.service.saver.save(saveFile);
/*     */     
/*  89 */     saveFile.l(this.total);
/*  90 */     saveFile.lsE(this.amounts);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  95 */     this.industryFuel.load(saveFile);
/*  96 */     this.service.saver.load(saveFile);
/*  97 */     this.total = saveFile.l();
/*  98 */     saveFile.lsE(this.amounts);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 103 */     this.industryFuel.clear();
/* 104 */     this.service.saver.clear();
/* 105 */     this.total = 0L;
/* 106 */     Arrays.fill(this.amounts, 0L);
/*     */   }
/*     */   
/*     */   public long totalFood() {
/* 110 */     return this.total;
/*     */   }
/*     */   
/*     */   public long amount(ResG e) {
/* 114 */     return this.amounts[e.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 119 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/* 124 */     return ((CanteenInstance)r).autoE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/* 129 */     ((CanteenInstance)r).autoE = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 134 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int grab(LIST<ResG> prefs, int amount, int tx, int ty) {
/* 140 */     ResG pref = (ResG)prefs.rnd();
/* 141 */     CanteenInstance ins = (CanteenInstance)this.getter.get(tx, ty);
/* 142 */     if (ins == null)
/* 143 */       return Meal.make(pref, 0, 0.0D); 
/* 144 */     FSERVICE f = this.food.get(tx, ty);
/* 145 */     if (f == null)
/* 146 */       return Meal.make(pref, 0, 0.0D); 
/* 147 */     f.consume();
/*     */ 
/*     */     
/* 150 */     if (amount > ins.amountTotal() - ins.serviceReserved() + 1) {
/* 151 */       amount = ins.amountTotal() - ins.serviceReserved() + 1;
/*     */     }
/* 153 */     int am = amount;
/*     */     
/* 155 */     int ipref = 0;
/* 156 */     int iopref = 0;
/*     */ 
/*     */ 
/*     */     
/* 160 */     if (am < 0) {
/* 161 */       GAME.Notify("here! " + am + " " + tx + " " + ty);
/* 162 */       return Meal.make(pref, 0, 0.0D);
/*     */     } 
/*     */     
/* 165 */     ResG ee = null;
/*     */     
/* 167 */     if (ins.amount(pref) > 0) {
/* 168 */       ee = pref;
/* 169 */       int a = Math.min(ins.amount(pref), am);
/* 170 */       am -= a;
/* 171 */       ipref += a;
/* 172 */       ins.consume(pref, a, tx, ty);
/* 173 */       GAME.player().res().inc(pref.resource, FResources.RTYPE.CONSUMED, -a);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (am > 0) {
/* 179 */       int ri = RND.rInt(prefs.size());
/* 180 */       for (int i = 0; i < prefs.size() && am > 0; i++) {
/* 181 */         ResG g = (ResG)prefs.getC(i + ri);
/* 182 */         if (ins.amount(g) > 0) {
/* 183 */           if (ee == null)
/* 184 */             ee = g; 
/* 185 */           int a = Math.min(ins.amount(g), am);
/* 186 */           am -= a;
/* 187 */           iopref += a;
/* 188 */           ins.consume(g, a, tx, ty);
/* 189 */           GAME.player().res().inc(g.resource, FResources.RTYPE.CONSUMED, -a);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 194 */     if (am > 0) {
/* 195 */       int ri = RND.rInt(RESOURCES.EDI().all().size());
/* 196 */       for (int i = 0; i < RESOURCES.EDI().all().size() && am > 0; i++) {
/* 197 */         ResG g = (ResG)RESOURCES.EDI().all().getC(i + ri);
/* 198 */         if (ins.amount(g) > 0) {
/* 199 */           if (ee == null)
/* 200 */             ee = g; 
/* 201 */           int a = Math.min(ins.amount(g), am);
/* 202 */           am -= a;
/* 203 */           ins.consume(g, a, tx, ty);
/* 204 */           GAME.player().res().inc(g.resource, FResources.RTYPE.CONSUMED, -a);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 209 */     if (ee == null) {
/* 210 */       ee = (ResG)RESOURCES.EDI().all().rnd();
/*     */     }
/* 212 */     amount -= am;
/* 213 */     int pt = ipref + iopref;
/* 214 */     double pv = 0.0D;
/* 215 */     if (pt > 0)
/* 216 */       pv = (ipref + 0.25D * iopref) / pt; 
/* 217 */     return Meal.make(ee, amount, pv);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE getChair(int tx, int ty) {
/* 222 */     return this.chair.get(tx, ty);
/*     */   }
/*     */   
/*     */   public DIR setChair(int tx, int ty, int mealData) {
/* 226 */     return this.chair.set(tx, ty, mealData);
/*     */   }
/*     */   
/*     */   public void returnChair(int tx, int ty) {
/* 230 */     this.chair.returnTable(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 236 */     return this.indus;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\ROOM_CANTEEN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */