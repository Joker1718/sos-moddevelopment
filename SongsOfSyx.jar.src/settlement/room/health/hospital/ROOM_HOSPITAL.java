/*     */ package settlement.room.health.hospital;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.Faction;
/*     */ import init.type.NEED;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_HOSPITAL extends RoomBlueprintIns<HospitalInstance> implements RoomService.ROOM_SERVICE_HASER, INDUSTRY_HASER {
/*     */   final RoomService service;
/*     */   final Constructor constructor;
/*  40 */   final ArrayListGrower<Lockable<Faction>> resLocks = new ArrayListGrower(); final Industry consumtion; final LIST<Industry> indus;
/*     */   
/*     */   public ROOM_HOSPITAL(RoomInitData init, RoomCategorySub block) throws IOException {
/*  43 */     super(0, init, "_HOSPITAL", block);
/*     */     
/*  45 */     this.service = new RoomService((RoomBlueprintImp)this, init, null)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  49 */           return Bed.service(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public double totalMultiplier() {
/*  54 */           return 1.0D;
/*     */         }
/*     */       };
/*     */     
/*  58 */     this.constructor = new Constructor(this, init);
/*  59 */     this.consumtion = new Industry((RoomBlueprintImp)this, init.data(), null)
/*     */       {
/*     */         public double consumptionRate(RoomInstance ins, Humanoid h, IndustryResource oo)
/*     */         {
/*  63 */           HospitalInstance ii = (HospitalInstance)ins;
/*  64 */           double n = ii.service().load() * ii.service().total();
/*  65 */           if (!ii.fetch[oo.index()])
/*  66 */             n = 0.0D; 
/*  67 */           if (ii.employees().employed() == 0)
/*  68 */             return 0.0D; 
/*  69 */           return n / ii.employees().employed();
/*     */         }
/*     */       };
/*     */     
/*  73 */     this.indus = (LIST<Industry>)new ArrayList(this.consumtion);
/*     */     
/*  75 */     employment().countInputSet();
/*     */     
/*  77 */     for (IndustryResource i : this.consumtion.ins()) {
/*  78 */       this.resLocks.add(GVALUES.FACTION.LOCK.push("ROOM_HOSPITAL_USE_" + i.resource.key, String.valueOf(this.info.name) + ": " + String.valueOf(this.info.name), i.resource.desc, (SPRITE)i.resource.icon()));
/*     */     }
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
/*  92 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  97 */     return this.service.finder;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomService service() {
/* 102 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter file) {
/* 107 */     this.consumtion.save(file);
/* 108 */     this.service.saver.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 113 */     this.consumtion.load(saveFile);
/* 114 */     this.service.saver.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 119 */     this.consumtion.clear();
/* 120 */     this.service.saver.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 125 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 131 */     return this.indus;
/*     */   }
/*     */   
/*     */   public DIR layCoo(int tx, int ty) {
/* 135 */     return (DIR)DIR.ORTHO.get((SETT.ROOMS()).fData.spriteData.get(tx, ty) & 0x3);
/*     */   }
/*     */   
/*     */   public double recoverRate(int tx, int ty) {
/* 139 */     double bo = ((HospitalInstance)get(tx, ty)).quality();
/* 140 */     if (Bed.res1(tx, ty)) {
/* 141 */       bo++;
/*     */     }
/* 143 */     if (Bed.res2(tx, ty)) {
/* 144 */       bo++;
/*     */     }
/* 146 */     return 1.0D - 0.8D / bo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double industryFormatConsumptionRate(GText text, IndustryResource i, RoomInstance ins) {
/* 152 */     HospitalInstance ii = (HospitalInstance)ins;
/* 153 */     double n = ii.service().load() * ii.service().total();
/* 154 */     if (!ii.fetch[i.index()])
/* 155 */       n = 0.0D; 
/* 156 */     GFORMAT.f0(text, -n);
/* 157 */     return n;
/*     */   }
/*     */   
/*     */   public void industryHoverConsumptionRate(GBox b, IndustryResource i, RoomInstance ins) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\ROOM_HOSPITAL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */