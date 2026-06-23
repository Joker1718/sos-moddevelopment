/*     */ package settlement.room.service.speaker;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_SPEAKER
/*     */   extends RoomBlueprintIns<SpeakerInstance> implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, ROOM_SPECTATOR.ROOM_SPECTATOR_HASER {
/*     */   final RoomServiceNeed data;
/*     */   final SpeakerConstructor constructor;
/*     */   final Centre work;
/*     */   private final ROOM_SPECTATOR spec;
/*     */   
/*     */   public ROOM_SPEAKER(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  35 */     super(index, init, key, block);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     this.spec = new ROOM_SPECTATOR()
/*     */       {
/*  92 */         private Coo coo = new Coo();
/*     */         
/*  94 */         private final byte[] acts = Alloc.bb(64);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public RoomServiceAccess service() {
/* 106 */           return (RoomServiceAccess)ROOM_SPEAKER.this.service();
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE lookAt(int sx, int sy) {
/* 111 */           SpeakerInstance ins = (SpeakerInstance)ROOM_SPEAKER.this.getter.get(sx, sy);
/* 112 */           if (ins == null) {
/* 113 */             this.coo.set(sx, sy);
/*     */           } else {
/* 115 */             this.coo.set(ins.body().cX(), ins.body().cY());
/*     */           } 
/* 117 */           this.coo.set((this.coo.x() * 64 + 32), (this.coo.y() * 64 + 32));
/* 118 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int sx, int sy) {
/* 123 */           SpeakerInstance ins = (SpeakerInstance)ROOM_SPEAKER.this.getter.get(sx, sy);
/* 124 */           return (ins != null);
/*     */         }
/*     */         
/*     */         private int activity(int sx, int sy) {
/* 128 */           SpeakerInstance ins = (SpeakerInstance)ROOM_SPEAKER.this.getter.get(sx, sy);
/* 129 */           if (ins == null)
/* 130 */             return 0; 
/* 131 */           if (!ROOM_SPEAKER.this.work.job(sx, sy).jobReservedIs(null))
/* 132 */             return 0; 
/* 133 */           int s = ins.off;
/*     */           
/* 135 */           s += (int)(this.acts.length * TIME.currentSecond() / TIME.secondsPerDay());
/* 136 */           s %= this.acts.length;
/* 137 */           return this.acts[s];
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldCheer(int sx, int sy) {
/* 142 */           return (activity(sx, sy) == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldBoo(int sx, int sy) {
/* 147 */           return (activity(sx, sy) == 2);
/*     */         }
/*     */         
/*     */         public void doSomeThingExtraWhenAccess(Humanoid a) {}
/*     */         
/*     */         public FSERVICE service(int tx, int ty) {
/*     */           return ROOM_SPEAKER.this.work.service(tx, ty);
/*     */         }
/*     */       };
/*     */     this.work = new Centre(this);
/*     */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init) { public boolean isActive(int sx, int sy) {
/* 158 */           SpeakerInstance ins = (SpeakerInstance)ROOM_SPEAKER.this.getter.get(sx, sy);
/* 159 */           if (ins == null)
/* 160 */             return false; 
/* 161 */           if (!ROOM_SPEAKER.this.work.job(sx, sy).jobReservedIs(null))
/* 162 */             return false; 
/* 163 */           return true;
/*     */         } }
/*     */       ;
/*     */     this.constructor = new SpeakerConstructor(this, init);
/*     */     employment().setShiftStart(ROOM_SPECTATOR.WORK_STARTSD, false);
/*     */   } public ROOM_SPECTATOR spec() {
/* 169 */     return this.spec;
/*     */   }
/*     */   
/*     */   protected void update(double ds) {}
/*     */   
/*     */   public Furnisher constructor() {
/*     */     return this.constructor;
/*     */   }
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*     */     return this.data.finder;
/*     */   }
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*     */     this.data.saver.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*     */     this.data.saver.load(saveFile);
/*     */   }
/*     */   
/*     */   protected void clearP() {
/*     */     this.data.saver.clear();
/*     */   }
/*     */   
/*     */   public RoomServiceNeed service() {
/*     */     return this.data;
/*     */   }
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\speaker\ROOM_SPEAKER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */