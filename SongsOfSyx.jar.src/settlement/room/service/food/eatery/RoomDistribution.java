/*      */ package settlement.room.service.food.eatery;
/*      */ 
/*      */ import game.GAME;
/*      */ import game.audio.SoundRace;
/*      */ import game.faction.FResources;
/*      */ import init.race.RACES;
/*      */ import init.race.Race;
/*      */ import init.resources.Meal;
/*      */ import init.resources.RBIT;
/*      */ import init.resources.RESOURCE;
/*      */ import init.resources.RESOURCES;
/*      */ import init.resources.ResG;
/*      */ import init.settings.S;
/*      */ import init.sprite.UI.UI;
/*      */ import java.io.IOException;
/*      */ import java.io.Serializable;
/*      */ import java.util.Arrays;
/*      */ import settlement.entity.humanoid.Humanoid;
/*      */ import settlement.entity.humanoid.ai.work.AIModule_Work;
/*      */ import settlement.main.SETT;
/*      */ import settlement.misc.job.JOBMANAGER_HASER;
/*      */ import settlement.misc.job.JOB_MANAGER;
/*      */ import settlement.misc.job.SETT_JOB;
/*      */ import settlement.misc.util.FSERVICE;
/*      */ import settlement.room.industry.module.Industry;
/*      */ import settlement.room.industry.module.IndustryResource;
/*      */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*      */ import settlement.room.main.ROOMA;
/*      */ import settlement.room.main.Room;
/*      */ import settlement.room.main.RoomBlueprintImp;
/*      */ import settlement.room.main.RoomBlueprintIns;
/*      */ import settlement.room.main.RoomInstance;
/*      */ import settlement.room.main.util.RoomBits;
/*      */ import settlement.room.main.util.RoomState;
/*      */ import settlement.room.main.util.RoomTally;
/*      */ import settlement.room.service.module.ROOM_SERVICER;
/*      */ import settlement.room.service.module.RoomService;
/*      */ import settlement.room.service.module.RoomServiceAccess;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.bit.Bits;
/*      */ import snake2d.util.datatypes.COORDINATE;
/*      */ import snake2d.util.datatypes.Coo;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.file.Alloc;
/*      */ import snake2d.util.file.FileGetter;
/*      */ import snake2d.util.file.FilePutter;
/*      */ import snake2d.util.file.SAVABLE;
/*      */ import snake2d.util.gui.GUI_BOX;
/*      */ import snake2d.util.gui.GuiSection;
/*      */ import snake2d.util.gui.renderable.RENDEROBJ;
/*      */ import snake2d.util.sets.ArrayList;
/*      */ import snake2d.util.sets.ArrayListGrower;
/*      */ import snake2d.util.sets.Bitmap1D;
/*      */ import snake2d.util.sets.LIST;
/*      */ import snake2d.util.sets.LISTE;
/*      */ import snake2d.util.sets.Stack;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import snake2d.util.sprite.text.Str;
/*      */ import util.data.GETTER;
/*      */ import util.gui.misc.GBox;
/*      */ import util.gui.misc.GButt;
/*      */ import util.gui.misc.GChart;
/*      */ import util.gui.misc.GGrid;
/*      */ import util.gui.misc.GStat;
/*      */ import util.gui.misc.GText;
/*      */ import util.info.GFORMAT;
/*      */ import util.statistics.HISTORY;
/*      */ import util.text.D;
/*      */ import util.text.Dic;
/*      */ import view.sett.ui.room.ModuleIndustry;
/*      */ import view.sett.ui.room.UIRoomModule;
/*      */ 
/*      */ public abstract class RoomDistribution implements SAVABLE {
/*   74 */   private static CharSequence ¤¤Consumed = "¤Consumed";
/*   75 */   private static CharSequence ¤¤uses = "¤Some or all stands are distributing this food. Click to disable this resource for all.";
/*   76 */   private static CharSequence ¤¤usesN = "¤No stands are distributing this food. Click to enable it for all";
/*   77 */   private static CharSequence ¤¤Preferred = "¤Preferred";
/*   78 */   private static CharSequence ¤¤worked = "¤How much this room is prepared. Some preparation is required before the resources can be consumed."; private final RoomBlueprintIns<? extends RoomDistributionIns> blue; private final RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER ser; private final Industry industry; public final LIST<RESOURCE> all;
/*      */   static {
/*   80 */     D.ts(RoomDistribution.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   89 */   private final int[] resourceIs = Alloc.ii(RESOURCES.ALL().size()); private final RBIT.RBITImp useMask;
/*      */   
/*   91 */   public final RoomTally tally = new RoomTally()
/*      */     {
/*      */       protected int[] data(RoomInstance ins)
/*      */       {
/*   95 */         return (((RoomDistribution.RoomDistributionIns)ins).distributionData()).tdata;
/*      */       }
/*      */     };
/*   98 */   public final RoomTally.TallyEntry tStored = this.tally.make(Dic.¤¤Stored);
/*   99 */   public final RoomTally.TallyEntry tIncoming = this.tally.make(Dic.¤¤Inbound);
/*  100 */   public final RoomTally.TallyEntry tReserved = this.tally.make("reserved");
/*      */   
/*      */   public final LIST<RoomTally.TallyEntry> allStored;
/*      */   public final LIST<RoomTally.TallyEntry> allIncoming;
/*  104 */   private final Crate crate = new Crate();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int maxRations;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final ArrayList<RESOURCE> shuffle;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Bitmap1D check;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int ci;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Bitmap1D ress;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RoomTally.TallyEntry stored(RESOURCE res) {
/*  154 */     return (RoomTally.TallyEntry)this.allStored.get(this.resourceIs[res.index()]);
/*      */   }
/*      */ 
/*      */   
/*      */   public void save(FilePutter file) {
/*  159 */     this.industry.save(file);
/*      */   }
/*      */ 
/*      */   
/*      */   public void load(FileGetter file) throws IOException {
/*  164 */     this.tally.clear();
/*  165 */     int ll = (this.tally.makeInstanceData()).length;
/*  166 */     for (int ii = 0; ii < this.blue.instancesSize(); ii++) {
/*  167 */       RoomInstance ins = this.blue.getInstance(ii);
/*  168 */       RoomDistributionIns d = (RoomDistributionIns)ins;
/*  169 */       InstanceData dd = d.distributionData();
/*  170 */       if (dd.tdata.length != ll) {
/*  171 */         dd.tdata = this.tally.makeInstanceData();
/*  172 */         dd.pdata = this.industry.makeData();
/*  173 */         dd.fetchMask.clear((RBIT)this.useMask);
/*  174 */         dd.useMask.clear((RBIT)this.useMask);
/*  175 */         for (COORDINATE c : ins.body()) {
/*  176 */           if (ins.is(c) && 
/*  177 */             init(c.x(), c.y())) {
/*  178 */             (SETT.ROOMS()).data.set((ROOMA)ins, c, 0);
/*      */           }
/*      */         } 
/*      */       } else {
/*      */         
/*  183 */         this.tally.load(ins);
/*      */       } 
/*      */     } 
/*  186 */     this.industry.load(file);
/*      */   }
/*      */ 
/*      */   
/*      */   public void clear() {
/*  191 */     this.tally.clear();
/*  192 */     this.industry.clear();
/*      */   }
/*      */   
/*      */   public InstanceData makeData(int maxAmount) {
/*  196 */     return new InstanceData(this, this.maxRations * maxAmount);
/*      */   }
/*      */   
/*      */   public SETT_JOB job(int tx, int ty) {
/*  200 */     if (!init(tx, ty))
/*  201 */       return null; 
/*  202 */     if (isCrate(tx, ty))
/*  203 */       return this.crate.workCook; 
/*  204 */     if (isDeposit(tx, ty))
/*  205 */       return this.crate.workRes; 
/*  206 */     return null;
/*      */   }
/*      */   
/*      */   public FSERVICE service(int tx, int ty) {
/*  210 */     if (init(tx, ty) && isCrate(tx, ty))
/*  211 */       return this.crate.service; 
/*  212 */     return null;
/*      */   }
/*      */   
/*      */   private boolean init(int tx, int ty) {
/*  216 */     RoomInstance ins = (RoomInstance)this.blue.getter.get(tx, ty);
/*  217 */     if (ins == null)
/*  218 */       return false; 
/*  219 */     this.crate.ins = ins;
/*  220 */     this.crate.data = (RoomDistributionIns)ins;
/*  221 */     this.crate.coo.set(tx, ty);
/*  222 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int consume(LIST<ResG> prefs, int amount, int tx, int ty) {
/*  229 */     ResG pref = (ResG)prefs.rnd();
/*      */ 
/*      */ 
/*      */     
/*  233 */     if (!init(tx, ty))
/*  234 */       return Meal.make(pref, 0, 0.0D); 
/*  235 */     int am = 0;
/*  236 */     double value = 0.0D;
/*      */     
/*  238 */     am = consume(pref.resource, amount, tx, ty);
/*  239 */     value = am;
/*  240 */     amount -= am;
/*      */     
/*  242 */     if (amount > 0) {
/*  243 */       this.check.clear();
/*  244 */       this.shuffle.clearSloppy();
/*  245 */       for (ResG e : prefs) {
/*  246 */         this.check.set(e.resource.index(), true);
/*  247 */         this.shuffle.add(e.resource);
/*      */       } 
/*  249 */       this.shuffle.shuffle();
/*  250 */       for (RESOURCE r : this.shuffle) {
/*  251 */         int a = consume(r, amount, tx, ty);
/*  252 */         am += a;
/*  253 */         value += 0.25D * a;
/*  254 */         amount -= a;
/*  255 */         if (amount <= 0)
/*      */           break; 
/*      */       } 
/*  258 */       if (amount > 0) {
/*  259 */         this.shuffle.clearSloppy();
/*  260 */         for (RESOURCE e : this.all) {
/*  261 */           if (!this.check.get(e.index()))
/*  262 */             this.shuffle.add(e); 
/*      */         } 
/*  264 */         this.shuffle.shuffle();
/*  265 */         for (RESOURCE r : this.shuffle) {
/*      */           
/*  267 */           int a = consume(r, amount, tx, ty);
/*      */           
/*  269 */           am += a;
/*  270 */           value += 0.25D * a;
/*  271 */           amount -= a;
/*  272 */           if (amount <= 0) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  278 */     if (am > 0) {
/*  279 */       value /= am;
/*      */     }
/*  281 */     return Meal.make(pref, am, value);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int consume(RESOURCE res, int amount, int tx, int ty) {
/*  287 */     if (!init(tx, ty)) {
/*  288 */       return 0;
/*      */     }
/*  290 */     if (this.crate.serviceReserved.get() == 1) {
/*  291 */       this.crate.serviceReserved.set((ROOMA)this.crate.ins, 0);
/*      */     }
/*      */     
/*  294 */     int ri = this.resourceIs[res.index()];
/*  295 */     int max = ((RoomTally.TallyEntry)this.allStored.get(ri)).get(this.crate.ins);
/*  296 */     max = Math.min(max, this.tStored.get(this.crate.ins));
/*  297 */     max = Math.min(amount, max);
/*  298 */     if (max > 0) {
/*  299 */       ((RoomTally.TallyEntry)this.allStored.get(ri)).inc(this.crate.ins, -max);
/*  300 */       this.crate.workAmount.inc((ROOMA)this.crate.ins, -1);
/*  301 */       ((IndustryResource)this.industry.ins().get(ri)).inc(this.crate.data.distributionData(), amount, false);
/*  302 */       GAME.player().res().inc(res, FResources.RTYPE.CONSUMED, -amount);
/*  303 */       setMask(res, this.crate.data.distributionData(), this.crate.ins);
/*  304 */       return max;
/*      */     } 
/*  306 */     return 0;
/*      */   }
/*      */   
/*      */   public void usesToggle(RESOURCE e, RoomInstance ins) {
/*  310 */     InstanceData dd = ((RoomDistributionIns)ins).distributionData();
/*      */     
/*  312 */     dump(e, dd, ins);
/*  313 */     dd.useMask.toggle(e);
/*  314 */     for (COORDINATE c : ins.body()) {
/*  315 */       if (ins.is(c) && 
/*  316 */         init(c.x(), c.y())) {
/*  317 */         this.crate.workAmount.set((ROOMA)ins, this.crate.workAmount.get());
/*      */       }
/*      */     } 
/*  320 */     setMask(e, dd, ins);
/*  321 */     ((RoomDistributionIns)ins).getWork().resetResourceSearch();
/*      */   }
/*      */   
/*      */   private void dump(RESOURCE e, InstanceData dd, RoomInstance ins) {
/*  325 */     if (dd.useMask.has(e)) {
/*  326 */       int am = stored(e).get(ins);
/*  327 */       ((RoomTally.TallyEntry)this.allStored.get(this.resourceIs[e.index()])).set(ins, 0);
/*  328 */       ((RoomTally.TallyEntry)this.allIncoming.get(this.resourceIs[e.index()])).set(ins, 0);
/*  329 */       if (am > 0) {
/*  330 */         (SETT.THINGS()).resources.create(ins.mX(), ins.mY(), e, am);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void setMask(RESOURCE e, InstanceData dd, RoomInstance ins) {
/*  336 */     if (((RoomTally.TallyEntry)this.allStored.get(this.resourceIs[e.index()])).get(ins) + ((RoomTally.TallyEntry)this.allIncoming.get(this.resourceIs[e.index()])).get(ins) + AIModule_Work.MAX_FETCH_AMOUNT < dd.maxAmount) {
/*  337 */       dd.fetchMask.or(e);
/*      */     } else {
/*  339 */       dd.fetchMask.clear(e);
/*      */     } 
/*  341 */     dd.fetchMask.and((RBIT)dd.useMask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose(RoomInstance ins) {
/*  348 */     InstanceData dd = ((RoomDistributionIns)ins).distributionData();
/*  349 */     for (RESOURCE r : this.all) {
/*  350 */       dump(r, dd, ins);
/*      */     }
/*  352 */     for (COORDINATE c : ins.body()) {
/*  353 */       if (ins.is(c) && 
/*  354 */         init(c.x(), c.y())) {
/*  355 */         this.crate.workAmount.set((ROOMA)this.crate.ins, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isWorked(int tx, int ty) {
/*  362 */     if (job(tx, ty) == this.crate.workCook)
/*  363 */       return (this.crate.workAmount.get() >= this.maxRations); 
/*  364 */     return false;
/*      */   }
/*      */   
/*      */   public int usedAmount(int tx, int ty) {
/*  368 */     if (job(tx, ty) == this.crate.workCook)
/*  369 */       return this.crate.serviceUsed.get(); 
/*  370 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static class InstanceData
/*      */     implements Serializable, ROOM_IDATA_INSTANCE
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */     int[] tdata;
/*      */     
/*      */     public final int maxAmount;
/*  382 */     private final RBIT.RBITImp fetchMask = (new RBIT.RBITImp()).clearSet((RESOURCES.EDI()).mask);
/*  383 */     private final RBIT.RBITImp useMask = new RBIT.RBITImp();
/*      */     float[] consumed;
/*      */     long[] pdata;
/*      */     
/*      */     InstanceData(RoomDistribution b, int maxAmount) {
/*  388 */       this.tdata = b.tally.makeInstanceData();
/*      */       
/*  390 */       this.maxAmount = maxAmount;
/*  391 */       this.useMask.clearSet((RBIT)b.useMask);
/*      */       
/*  393 */       this.pdata = b.industry.makeData();
/*      */       
/*  395 */       for (int ei = 0; ei < b.all.size(); ei++) {
/*  396 */         RESOURCE e = (RESOURCE)b.all.get(ei);
/*  397 */         if (b.blue.instancesSize() > 1 && !b.uses(e)) {
/*  398 */           this.useMask.set(e, false);
/*      */         }
/*      */       } 
/*  401 */       this.fetchMask.clearSet((RBIT)b.useMask);
/*      */     }
/*      */ 
/*      */     
/*      */     public long[] productionData() {
/*  406 */       return this.pdata;
/*      */     }
/*      */ 
/*      */     
/*      */     public JOB_MANAGER getWork() {
/*  411 */       return null;
/*      */     }
/*      */     
/*      */     public void update(RoomDistribution b) {
/*  415 */       b.industry.updateRoom(this);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   final class Crate
/*      */   {
/*  422 */     private final Coo coo = new Coo();
/*      */     private RoomInstance ins;
/*      */     private RoomDistribution.RoomDistributionIns data;
/*  425 */     private final RoomBits serviceReserved = new BB(new Bits(1));
/*  426 */     private final RoomBits serviceReservable = new RoomBits((COORDINATE)this.coo, new Bits(2));
/*  427 */     private final RoomBits freeWork = new RoomBits((COORDINATE)this.coo, new Bits(4));
/*  428 */     private final RoomBits workReserved = new RoomBits((COORDINATE)this.coo, new Bits(8));
/*  429 */     private final RoomBits serviceUsed = new RoomBits((COORDINATE)this.coo, new Bits(240));
/*  430 */     private final RoomBits workAmount = new BB(new Bits(65280));
/*      */     
/*      */     private SETT_JOB workCook;
/*      */     
/*      */     private final SETT_JOB workRes;
/*      */     private final FSERVICE service;
/*      */     
/*      */     Crate() {
/*  438 */       this.workCook = new SETT_JOB()
/*      */         {
/*  440 */           private final int wt = 30;
/*      */ 
/*      */           
/*      */           public boolean jobUseTool() {
/*  444 */             return false;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void jobStartPerforming() {}
/*      */ 
/*      */ 
/*      */           
/*      */           public SoundRace jobSound() {
/*  454 */             return (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).blue.employment().sound();
/*      */           }
/*      */ 
/*      */           
/*      */           public RBIT jobResourceBitToFetch() {
/*  459 */             return null;
/*      */           }
/*      */ 
/*      */           
/*      */           public int jobResourcesNeeded(Humanoid skill) {
/*  464 */             return (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean jobReservedIs(RESOURCE r) {
/*  469 */             return (RoomDistribution.Crate.this.workReserved.get() == 1);
/*      */           }
/*      */ 
/*      */           
/*      */           public void jobReserveCancel(RESOURCE r) {
/*  474 */             RoomDistribution.Crate.this.workReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean jobReserveCanBe() {
/*  479 */             return (RoomDistribution.Crate.this.workReserved.get() == 0 && RoomDistribution.Crate.this.workAmount.get() <= (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations * 8 && (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tStored.get(RoomDistribution.Crate.this.ins) - (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tReserved.get(RoomDistribution.Crate.this.ins) > (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void jobReserve(RESOURCE r) {
/*  486 */             RoomDistribution.Crate.this.workReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*      */           }
/*      */ 
/*      */           
/*      */           public double jobPerformTime(Humanoid skill) {
/*  491 */             return ((RoomDistribution.Crate.this.freeWork.get() == 1) ? true : 30);
/*      */           }
/*      */ 
/*      */           
/*      */           public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/*  496 */             RoomDistribution.Crate.this.workReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*  497 */             RoomDistribution.Crate.this.workAmount.inc((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*  498 */             if (RoomDistribution.Crate.this.ins.employees().fetchBonusConsume(31)) {
/*  499 */               RoomDistribution.Crate.this.freeWork.set((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*      */             } else {
/*  501 */               RoomDistribution.Crate.this.freeWork.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*      */             } 
/*  503 */             return null;
/*      */           }
/*      */ 
/*      */           
/*      */           public CharSequence jobName() {
/*  508 */             return ((RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).blue.employment()).verb;
/*      */           }
/*      */ 
/*      */           
/*      */           public COORDINATE jobCoo() {
/*  513 */             return (COORDINATE)RoomDistribution.Crate.this.coo;
/*      */           }
/*      */         };
/*      */       
/*  517 */       this.workRes = new SETT_JOB()
/*      */         {
/*      */           public boolean jobUseTool()
/*      */           {
/*  521 */             return false;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void jobStartPerforming() {}
/*      */ 
/*      */ 
/*      */           
/*      */           public SoundRace jobSound() {
/*  531 */             return (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).blue.employment().sound();
/*      */           }
/*      */ 
/*      */           
/*      */           public RBIT jobResourceBitToFetch() {
/*  536 */             return (RBIT)(RoomDistribution.Crate.this.data.distributionData()).fetchMask;
/*      */           }
/*      */ 
/*      */           
/*      */           public int jobResourcesNeeded(Humanoid skill) {
/*  541 */             return (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean jobReservedIs(RESOURCE r) {
/*  546 */             if (r == null) {
/*  547 */               return false;
/*      */             }
/*  549 */             int ri = (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).resourceIs[r.index()];
/*  550 */             if (ri < 0) {
/*  551 */               return false;
/*      */             }
/*      */             
/*  554 */             return (((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).get(RoomDistribution.Crate.this.ins) > 0);
/*      */           }
/*      */ 
/*      */           
/*      */           public void jobReserveCancel(RESOURCE r) {
/*  559 */             if (r == null)
/*      */               return; 
/*  561 */             int ri = (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).resourceIs[r.index()];
/*  562 */             if (ri < 0)
/*      */               return; 
/*  564 */             if (((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).get(RoomDistribution.Crate.this.ins) >= AIModule_Work.MAX_FETCH_AMOUNT)
/*  565 */               ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).inc(RoomDistribution.Crate.this.ins, -AIModule_Work.MAX_FETCH_AMOUNT); 
/*  566 */             RoomDistribution.Crate.access$0(RoomDistribution.Crate.this).setMask(r, (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.data.distributionData(), (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.ins);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean jobReserveCanBe() {
/*  571 */             return !(RoomDistribution.Crate.this.data.distributionData()).fetchMask.isClear();
/*      */           }
/*      */ 
/*      */           
/*      */           public void jobReserve(RESOURCE r) {
/*  576 */             int ri = (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).resourceIs[r.index()];
/*  577 */             ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).inc(RoomDistribution.Crate.this.ins, AIModule_Work.MAX_FETCH_AMOUNT);
/*  578 */             RoomDistribution.Crate.access$0(RoomDistribution.Crate.this).setMask(r, (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.data.distributionData(), (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.ins);
/*      */           }
/*      */ 
/*      */           
/*      */           public double jobPerformTime(Humanoid skill) {
/*  583 */             return 0.0D;
/*      */           }
/*      */ 
/*      */           
/*      */           public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/*  588 */             int ri = (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).resourceIs[r.index()];
/*  589 */             if (ri >= 0 && ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).get(RoomDistribution.Crate.this.ins) > 0) {
/*  590 */               ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).inc(RoomDistribution.Crate.this.ins, -AIModule_Work.MAX_FETCH_AMOUNT);
/*  591 */               ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allStored.get(ri)).inc(RoomDistribution.Crate.this.ins, ram);
/*  592 */               RoomDistribution.Crate.this.workAmount.set((ROOMA)RoomDistribution.Crate.this.ins, RoomDistribution.Crate.this.workAmount.get());
/*  593 */               RoomDistribution.Crate.access$0(RoomDistribution.Crate.this).setMask(r, (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.data.distributionData(), (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.ins);
/*      */             } 
/*  595 */             return null;
/*      */           }
/*      */ 
/*      */           
/*      */           public CharSequence jobName() {
/*  600 */             return ((RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).blue.employment()).verb;
/*      */           }
/*      */ 
/*      */           
/*      */           public COORDINATE jobCoo() {
/*  605 */             return (COORDINATE)RoomDistribution.Crate.this.coo;
/*      */           }
/*      */         };
/*      */       
/*  609 */       this.service = new FSERVICE()
/*      */         {
/*      */ 
/*      */           
/*      */           public boolean findableReservedCanBe()
/*      */           {
/*  615 */             return (RoomDistribution.Crate.this.serviceReservable.get() == 1 && RoomDistribution.Crate.this.serviceReserved.get() == 0);
/*      */           }
/*      */ 
/*      */           
/*      */           public void findableReserve() {
/*  620 */             RoomDistribution.Crate.this.serviceReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean findableReservedIs() {
/*  625 */             return (RoomDistribution.Crate.this.serviceReserved.get() == 1);
/*      */           }
/*      */ 
/*      */           
/*      */           public void findableReserveCancel() {
/*  630 */             RoomDistribution.Crate.this.serviceReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*  631 */             RoomDistribution.Crate.this.serviceUsed.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*      */           }
/*      */ 
/*      */           
/*      */           public void startUsing() {
/*  636 */             RoomDistribution.Crate.this.serviceUsed.inc((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*      */           }
/*      */ 
/*      */           
/*      */           public int x() {
/*  641 */             return RoomDistribution.Crate.this.coo.x();
/*      */           }
/*      */ 
/*      */           
/*      */           public int y() {
/*  646 */             return RoomDistribution.Crate.this.coo.y();
/*      */           }
/*      */ 
/*      */           
/*      */           public void consume() {
/*  651 */             findableReserveCancel();
/*      */           }
/*      */         };
/*      */     }
/*      */     
/*      */     private class BB
/*      */       extends RoomBits {
/*      */       public BB(Bits bits) {
/*  659 */         super((COORDINATE)RoomDistribution.Crate.this.coo, bits);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected void remove() {
/*  665 */         if (RoomDistribution.Crate.this.serviceReservable.get() == 1) {
/*  666 */           (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tReserved.inc(RoomDistribution.Crate.this.ins, -(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations);
/*  667 */           if (RoomDistribution.Crate.this.serviceReserved.get() == 0) {
/*  668 */             RoomDistribution.Crate.this.data.service().report(RoomDistribution.Crate.this.service, (RoomService)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).ser.service(), -1);
/*      */           }
/*      */         } 
/*      */         
/*  672 */         super.remove();
/*      */       }
/*      */ 
/*      */       
/*      */       protected void add() {
/*  677 */         RoomDistribution.Crate.this.serviceReservable.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*  678 */         if (RoomDistribution.Crate.this.workAmount.get() >= 1 && (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tStored.get(RoomDistribution.Crate.this.ins) - (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tReserved.get(RoomDistribution.Crate.this.ins) >= (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations) {
/*  679 */           RoomDistribution.Crate.this.serviceReservable.set((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*  680 */           (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tReserved.inc(RoomDistribution.Crate.this.ins, (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations);
/*  681 */           if (RoomDistribution.Crate.this.serviceReserved.get() == 0) {
/*  682 */             RoomDistribution.Crate.this.data.service().report(RoomDistribution.Crate.this.service, (RoomService)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).ser.service(), 1);
/*      */           }
/*      */         } 
/*  685 */         super.add();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class State
/*      */     extends RoomState.RoomStateInstance
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */     
/*  700 */     private final RBIT.RBITImp useMask = new RBIT.RBITImp();
/*      */ 
/*      */     
/*      */     public State(RoomDistribution.RoomDistributionIns ins, boolean broken) {
/*  704 */       super((RoomInstance)ins);
/*  705 */       this.useMask.clearSet((RBIT)(ins.distributionData()).useMask);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void applyIns(RoomInstance ins) {
/*  711 */       if (ins instanceof RoomDistribution.RoomDistributionIns) {
/*  712 */         RoomDistribution.RoomDistributionIns s = (RoomDistribution.RoomDistributionIns)ins;
/*  713 */         for (RESOURCE g : (s.distributionNlueData()).all) {
/*  714 */           if (this.useMask.has(g) != (s.distributionData()).useMask.has(g)) {
/*  715 */             s.distributionNlueData().usesToggle(g, ins);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public State makeState(RoomDistributionIns ins, boolean broken) {
/*  723 */     return new State(ins, broken);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendView(LISTE<UIRoomModule> mm, CharSequence food) {
/*  733 */     mm.add(new Gui(food));
/*      */   }
/*      */ 
/*      */   
/*      */   class Gui
/*      */     extends UIRoomModule
/*      */   {
/*      */     private final CharSequence sFood;
/*      */     
/*      */     Gui(CharSequence food) {
/*  743 */       this.sFood = food;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/*  751 */       GuiSection s = new GuiSection();
/*  752 */       int i = 0;
/*  753 */       for (RESOURCE e : RoomDistribution.this.all) {
/*  754 */         final int ri = RoomDistribution.this.resourceIs[e.index()];
/*  755 */         GButt.BSection bSection = new GButt.BSection()
/*      */           {
/*      */             public void hoverInfoGet(GUI_BOX text)
/*      */             {
/*  759 */               RoomDistribution.RoomDistributionIns ins = (RoomDistribution.RoomDistributionIns)get.get();
/*      */               
/*  761 */               GBox b = (GBox)text;
/*  762 */               b.title(e.name);
/*  763 */               b.textLL(((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).name);
/*  764 */               b.tab(6);
/*  765 */               b.add((SPRITE)GFORMAT.iofkInv(b.text(), ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).get((RoomInstance)get.get()), (ins.distributionData()).maxAmount));
/*  766 */               b.NL();
/*  767 */               b.textLL(((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allIncoming.get(ri)).name);
/*  768 */               b.tab(6);
/*  769 */               b.add((SPRITE)GFORMAT.i(b.text(), ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allIncoming.get(ri)).get((RoomInstance)get.get())));
/*  770 */               b.NL();
/*      */ 
/*      */               
/*  773 */               b.textLL(String.valueOf(RoomDistribution.¤¤Consumed) + "(" + String.valueOf(RoomDistribution.¤¤Consumed) + ")");
/*  774 */               b.tab(6);
/*  775 */               b.add((SPRITE)GFORMAT.i(b.text(), (int)-((IndustryResource)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).industry.ins().get(ri)).day.getD(ins.distributionData())));
/*  776 */               b.NL();
/*  777 */               b.textLL(String.valueOf(RoomDistribution.¤¤Consumed) + "(" + String.valueOf(RoomDistribution.¤¤Consumed) + ")");
/*  778 */               b.tab(6);
/*  779 */               b.add((SPRITE)GFORMAT.i(b.text(), -((IndustryResource)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).industry.ins().get(ri)).year.get(ins.distributionData())));
/*  780 */               b.NL();
/*      */               
/*  782 */               b.sep();
/*  783 */               b.textLL(RoomDistribution.¤¤Preferred);
/*  784 */               b.NL();
/*  785 */               for (Race r : RACES.all()) {
/*  786 */                 if (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).isPref(e, r)) {
/*  787 */                   b.add((SPRITE)(r.appearance()).icon);
/*      */                 }
/*      */               } 
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             protected void renAction() {
/*  795 */               RoomDistribution.RoomDistributionIns ins = (RoomDistribution.RoomDistributionIns)get.get();
/*  796 */               selectedSet((ins.distributionData()).useMask.has(e));
/*      */             }
/*      */ 
/*      */             
/*      */             protected void clickA() {
/*  801 */               RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).usesToggle(e, (RoomInstance)get.get());
/*      */             }
/*      */           };
/*      */ 
/*      */         
/*  806 */         bSection.addRightC(4, (SPRITE)e.icon());
/*      */         
/*  808 */         bSection.addRightC(4, (SPRITE)new GStat()
/*      */             {
/*      */               public void update(GText text)
/*      */               {
/*  812 */                 GFORMAT.i(text, ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).get((RoomInstance)get.get()));
/*      */               }
/*      */ 
/*      */               
/*      */               public void hoverInfoGet(GBox b) {
/*  817 */                 b.title(e.name);
/*  818 */                 b.textLL(RoomDistribution.Gui.this.sFood).add((SPRITE)GFORMAT.i(b.text(), ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).get((RoomInstance)get.get())));
/*      */               }
/*      */             });
/*      */         
/*  822 */         bSection.body().incrW(48.0D);
/*  823 */         bSection.pad(4);
/*      */         
/*  825 */         s.add((RENDEROBJ)bSection, i % 3 * bSection.body().width(), i / 3 * bSection.body().height());
/*  826 */         i++;
/*      */       } 
/*      */ 
/*      */       
/*  830 */       GuiSection ss = new GuiSection();
/*  831 */       ss.add((RENDEROBJ)(new GStat()
/*      */           {
/*      */             public void update(GText text)
/*      */             {
/*  835 */               GFORMAT.i(text, (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tStored.get((RoomInstance)get.get()));
/*      */             }
/*      */ 
/*      */             
/*      */             public void hoverInfoGet(GBox b) {
/*  840 */               if ((S.get()).developer) {
/*  841 */                 b.textLL((RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tStored.name);
/*  842 */                 b.add((SPRITE)GFORMAT.i(b.text(), (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tStored.get((RoomInstance)get.get())));
/*  843 */                 b.NL();
/*  844 */                 b.textLL((RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tIncoming.name);
/*  845 */                 b.add((SPRITE)GFORMAT.i(b.text(), (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tIncoming.get((RoomInstance)get.get())));
/*  846 */                 b.NL();
/*  847 */                 b.textLL((RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tReserved.name);
/*  848 */                 b.add((SPRITE)GFORMAT.i(b.text(), (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tReserved.get((RoomInstance)get.get())));
/*  849 */                 b.NL();
/*      */               }
/*      */             
/*      */             }
/*  853 */           }).hh(this.sFood));
/*      */       
/*  855 */       ss.addRightC(48, (RENDEROBJ)(new GStat()
/*      */           {
/*      */             
/*      */             public void update(GText text)
/*      */             {
/*  860 */               double tot = 0.0D;
/*  861 */               double worked = 0.0D;
/*      */               
/*  863 */               for (COORDINATE c : ((RoomInstance)get.get()).body()) {
/*  864 */                 if (((RoomInstance)get.get()).is(c) && 
/*  865 */                   RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).isCrate(c.x(), c.y()) && RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).job(c.x(), c.y()) != null) {
/*  866 */                   tot += ((RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).maxRations * 8);
/*  867 */                   worked += (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).crate.workAmount.get();
/*      */                 } 
/*      */               } 
/*      */ 
/*      */               
/*  872 */               GFORMAT.perc(text, worked / tot);
/*      */             }
/*  875 */           }).hh((SPRITE)(UI.icons()).s.hammer).hoverInfoSet(RoomDistribution.¤¤worked));
/*      */       
/*  877 */       ss.addRightC(48, ModuleIndustry.makeFetch(get));
/*  878 */       ss.body().incrW(48.0D);
/*      */       
/*  880 */       s.addRelBody(2, DIR.N, (RENDEROBJ)ss);
/*      */       
/*  882 */       section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void hover(GBox b, Room room, int rx, int ry) {
/*  888 */       RoomInstance ins = (RoomInstance)room;
/*  889 */       RoomDistribution.RoomDistributionIns dd = (RoomDistribution.RoomDistributionIns)room;
/*  890 */       b.NL();
/*  891 */       b.textLL(this.sFood).add((SPRITE)GFORMAT.i(b.text(), RoomDistribution.this.tStored.get(ins)));
/*  892 */       b.NL();
/*  893 */       for (int i = 0; i < RoomDistribution.this.all.size(); i++) {
/*  894 */         RESOURCE r = (RESOURCE)RoomDistribution.this.all.get(i);
/*  895 */         b.add((SPRITE)r.icon());
/*  896 */         GText t = b.text();
/*  897 */         GFORMAT.i(t, ((RoomTally.TallyEntry)RoomDistribution.this.allStored.get(i)).get(ins));
/*  898 */         if (!(dd.distributionData()).useMask.has(r))
/*  899 */           t.errorify(); 
/*  900 */         b.add((SPRITE)t);
/*  901 */         b.space();
/*  902 */         if (i % 6 == 5) {
/*  903 */           b.NL();
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  908 */       b.NL();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/*  915 */       GuiSection s = new GuiSection();
/*  916 */       final GChart cc = new GChart();
/*      */       
/*  918 */       int i = 0;
/*  919 */       int m = 5;
/*      */ 
/*      */ 
/*      */       
/*  923 */       for (RESOURCE e : RoomDistribution.this.all) {
/*  924 */         final int ri = RoomDistribution.this.resourceIs[e.index()];
/*      */         
/*  926 */         SPRITE.Imp imp = new SPRITE.Imp(70, 24)
/*      */           {
/*  928 */             GText t = new GText((UI.FONT()).S, 6);
/*      */ 
/*      */             
/*      */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  932 */               e.icon().render(r, X1, Y1);
/*  933 */               this.t.clear();
/*  934 */               GFORMAT.i(this.t, ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).total.get());
/*  935 */               this.t.renderCY(r, X1 + 26, Y1 + (Y2 - Y1) / 2);
/*      */             }
/*      */           };
/*      */         
/*  939 */         GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)imp)
/*      */           {
/*      */             protected void clickA() {
/*  942 */               if (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).uses(e)) {
/*  943 */                 for (int i = 0; i < (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.instancesSize(); i++) {
/*  944 */                   RoomDistribution.RoomDistributionIns ii = (RoomDistribution.RoomDistributionIns)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.getInstance(i);
/*  945 */                   if ((ii.distributionData()).useMask.has(e)) {
/*  946 */                     RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).usesToggle(e, (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.getInstance(i));
/*      */                   }
/*      */                 } 
/*      */               } else {
/*  950 */                 for (int i = 0; i < (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.instancesSize(); i++) {
/*  951 */                   RoomDistribution.RoomDistributionIns ii = (RoomDistribution.RoomDistributionIns)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.getInstance(i);
/*  952 */                   if (!(ii.distributionData()).useMask.has(e)) {
/*  953 */                     RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).usesToggle(e, (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.getInstance(i));
/*      */                   }
/*      */                 } 
/*      */               } 
/*  957 */               super.clickA();
/*      */             }
/*      */ 
/*      */             
/*      */             public void hoverInfoGet(GUI_BOX text) {
/*  962 */               GBox b = (GBox)text;
/*  963 */               b.title(e.name);
/*  964 */               if (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).uses(e)) {
/*  965 */                 b.text(RoomDistribution.¤¤uses);
/*      */               } else {
/*  967 */                 b.text(RoomDistribution.¤¤usesN);
/*      */               } 
/*  969 */               b.NL();
/*      */               
/*  971 */               b.title(e.name);
/*  972 */               b.textLL(((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).name);
/*  973 */               b.tab(6);
/*  974 */               b.add((SPRITE)GFORMAT.i(b.text(), ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).total.get()));
/*  975 */               b.NL(8);
/*  976 */               b.textLL(RoomDistribution.¤¤Consumed);
/*  977 */               b.tab(6);
/*  978 */               b.add((SPRITE)GFORMAT.i(b.text(), -((IndustryResource)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).industry.ins().get(ri)).history().get()));
/*  979 */               b.NL();
/*  980 */               cc.clear();
/*  981 */               cc.add((HISTORY)((IndustryResource)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).industry.ins().get(ri)).history());
/*  982 */               b.add((RENDEROBJ)cc);
/*      */               
/*  984 */               b.sep();
/*  985 */               b.textLL(RoomDistribution.¤¤Preferred);
/*  986 */               b.NL();
/*  987 */               for (Race r : RACES.all()) {
/*  988 */                 if ((r.pref()).foodMask.has(e)) {
/*  989 */                   b.add((SPRITE)(r.appearance()).icon);
/*      */                 }
/*      */               } 
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             protected void renAction() {
/*  997 */               selectedSet(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).uses(e));
/*      */             }
/*      */           };
/*      */         
/* 1001 */         s.add((RENDEROBJ)buttPanel, i % m * buttPanel.body().width(), i / m * buttPanel.body().height());
/* 1002 */         i++;
/*      */       } 
/*      */ 
/*      */       
/* 1006 */       s.add((RENDEROBJ)(new GStat()
/*      */           {
/*      */             public void update(GText text)
/*      */             {
/* 1010 */               GFORMAT.i(text, (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tStored.total.get());
/*      */             }
/* 1013 */           }).hh(this.sFood), 0, s.body().y1() - 16);
/*      */       
/* 1015 */       text.add((RENDEROBJ)s);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room r, int rx, int ry) {
/* 1024 */       ModuleIndustry.fetchProblem(free, errors, warnings, (RoomInstance)r);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public RoomDistribution(RoomBlueprintIns<? extends RoomDistributionIns> e, RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER ser, LIST<RESOURCE> all, RBIT.RBITImp useMask, int maxRations) {
/* 1030 */     this.ci = -1;
/* 1031 */     this.ress = new Bitmap1D(RESOURCES.ALL().size(), false); this.blue = e; this.ser = ser; RESOURCE[] ires = new RESOURCE[all.size()]; int i; for (i = 0; i < all.size(); i++) ires[i] = (RESOURCE)all.get(i);  this.industry = new Industry((RoomBlueprintImp)e, ires, new double[all.size()], null); this.useMask = new RBIT.RBITImp(); this.useMask.clear(); this.all = (LIST<RESOURCE>)new ArrayList((Iterable)all); Arrays.fill(this.resourceIs, -1); for (i = 0; i < all.size(); i++) { this.resourceIs[((RESOURCE)all.get(i)).index()] = i; if (useMask.has((RESOURCE)all.get(i))) this.useMask.set((RESOURCE)all.get(i), true);  }  this.maxRations = maxRations; ArrayListGrower<RoomTally.TallyEntry> tt = new ArrayListGrower(); for (RESOURCE t : all)
/*      */       tt.add(this.tally.make(Dic.¤¤Stored, this.tStored));  this.allStored = (LIST<RoomTally.TallyEntry>)tt; tt = new ArrayListGrower(); for (RESOURCE t : all)
/* 1033 */       tt.add(this.tally.make(Dic.¤¤Inbound, this.tIncoming));  this.allIncoming = (LIST<RoomTally.TallyEntry>)tt; this.shuffle = new ArrayList(all.size()); this.check = new Bitmap1D(RESOURCES.ALL().size(), false); } public boolean uses(RESOURCE rr) { if (this.ci == GAME.updateI())
/* 1034 */       return this.ress.get(rr.index()); 
/* 1035 */     this.ci = GAME.updateI();
/* 1036 */     this.ress.clear();
/*      */     
/* 1038 */     for (int ri = 0; ri < this.all.size(); ri++) {
/* 1039 */       RESOURCE r = (RESOURCE)this.all.get(ri);
/* 1040 */       for (int i = 0; i < this.blue.instancesSize(); i++) {
/* 1041 */         RoomDistributionIns ii = (RoomDistributionIns)this.blue.getInstance(i);
/* 1042 */         if (ii.distributionData() != null && (ii.distributionData()).useMask.has(r)) {
/* 1043 */           this.ress.set(r.index(), true);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1049 */     return this.ress.get(rr.index()); }
/*      */ 
/*      */   
/*      */   protected abstract boolean isCrate(int paramInt1, int paramInt2);
/*      */   
/*      */   protected abstract boolean isDeposit(int paramInt1, int paramInt2);
/*      */   
/*      */   protected abstract boolean isPref(RESOURCE paramRESOURCE, Race paramRace);
/*      */   
/*      */   public static interface RoomDistributionIns extends JOBMANAGER_HASER, ROOM_SERVICER {
/*      */     RoomDistribution.InstanceData distributionData();
/*      */     
/*      */     RoomDistribution distributionNlueData();
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\RoomDistribution.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */