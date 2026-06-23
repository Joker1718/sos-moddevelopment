/*     */ package settlement.room.food.hunter;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public class ROOM_HUNTER extends RoomBlueprintIns<HunterInstance> implements INDUSTRY_HASER {
/*     */   public static final String type = "HUNTER";
/*     */   final Constructor constructor;
/*  42 */   public double luck = 1.0D; final LIST<Industry> indus; final Tile tile;
/*  43 */   private int year = -1;
/*     */   
/*     */   public final int MAX_EMPLOYED;
/*     */   
/*  47 */   private static CharSequence ¤¤emp = "The more employees you have, the less efficient this industry will become. The max amount for this room is {0}. Employees after that point will decrease the output gradually.";
/*  48 */   private static CharSequence ¤¤luck = "Luck";
/*  49 */   private static CharSequence ¤¤luckD = "How lucky your hunters are. Changes annually";
/*     */   public final RoomBoost bEmployed;
/*     */   
/*     */   static {
/*  53 */     D.ts(ROOM_HUNTER.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_HUNTER(int index, RoomInitData init, String key, RoomCategorySub cat) throws IOException {
/*  59 */     super(index, init, key, cat);
/*     */     
/*  61 */     this.constructor = new Constructor(this, init);
/*  62 */     pushBo(init.data(), "HUNTER", true);
/*  63 */     this.MAX_EMPLOYED = init.data().i("MAX_EMPLOYED", 1, 10000);
/*     */ 
/*     */ 
/*     */     
/*  67 */     this.bEmployed = new RoomBoost() {
/*  68 */         INFO info = new INFO(Dic.¤¤Employees, String.valueOf(Str.TMP.clear().add(ROOM_HUNTER.¤¤emp).insert(0, ROOM_HUNTER.this.MAX_EMPLOYED)));
/*     */ 
/*     */         
/*     */         public INFO info() {
/*  72 */           return this.info;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(RoomInstance r) {
/*  77 */           return ROOM_HUNTER.this.eBonus(0);
/*     */         }
/*     */       };
/*     */     
/*  81 */     RoomBoost bluck = new RoomBoost() {
/*  82 */         INFO info = new INFO(ROOM_HUNTER.¤¤luck, ROOM_HUNTER.¤¤luckD);
/*     */         
/*     */         public INFO info() {
/*  85 */           return this.info;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(RoomInstance r) {
/*  90 */           return ROOM_HUNTER.this.luck;
/*     */         }
/*     */ 
/*     */         
/*     */         public double min() {
/*  95 */           return 0.6D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double max() {
/* 100 */           return 1.4D;
/*     */         }
/*     */       };
/*     */     
/* 104 */     this.indus = Industry.createIndustries((RoomBlueprintImp)this, init, new RoomBoost[] { this.bEmployed, bluck, (RoomBoost)this.constructor.efficiency }, bonus());
/* 105 */     for (Industry i : this.indus)
/* 106 */       i.isOnlyRoomDoNotUse = true; 
/* 107 */     this.tile = new Tile(this);
/*     */   }
/*     */   
/*     */   public double eBonus(int delta) {
/* 111 */     double emp = (employment().employed() + delta);
/* 112 */     if (emp < this.MAX_EMPLOYED)
/* 113 */       return 1.0D; 
/* 114 */     double d = 1.0D + (emp - this.MAX_EMPLOYED) / (this.MAX_EMPLOYED * 4);
/* 115 */     return 1.0D / d;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 120 */     if (this.year != TIME.years().bitsSinceStart()) {
/* 121 */       this.luck = RND.rFloat1(0.4D);
/* 122 */       this.year = TIME.years().bitsSinceStart();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 134 */     IndustryUtil.save(saveFile, this.indus);
/* 135 */     saveFile.d(this.luck);
/* 136 */     saveFile.i(this.year);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 141 */     IndustryUtil.load(saveFile, this.indus);
/* 142 */     this.luck = saveFile.d();
/* 143 */     this.year = saveFile.i();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 148 */     IndustryUtil.clear(this.indus);
/* 149 */     this.luck = 1.0D;
/* 150 */     this.year = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 155 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<Industry> industries() {
/* 165 */     return this.indus;
/*     */   }
/*     */   
/*     */   public void resetGore(COORDINATE c) {
/* 169 */     this.tile.reset((HunterInstance)this.getter.get(c), c);
/*     */   }
/*     */   
/*     */   public void gore(COORDINATE c) {
/* 173 */     this.tile.gore((HunterInstance)this.getter.get(c), c);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE reserveWork(RoomInstance inss, Humanoid h) {
/* 178 */     COORDINATE start = h.tc();
/*     */ 
/*     */     
/* 181 */     HunterInstance ins = (HunterInstance)inss;
/*     */     
/* 183 */     for (DIR d : DIR.ORTHO) {
/* 184 */       Tile j = this.tile.init(start.x() + d.x(), start.y() + d.y(), ins);
/* 185 */       if (j != null && j.reserved.get() == 0) {
/* 186 */         return clean(j);
/*     */       }
/*     */     } 
/*     */     
/* 190 */     ArrayCooShort coos = ins.coos;
/* 191 */     for (int i = 0; i < coos.size(); i++) {
/* 192 */       coos.inc();
/* 193 */       Tile j = this.tile.init(coos.get().x(), coos.get().y(), ins);
/* 194 */       if (j.reserved.get() == 0) {
/* 195 */         return clean(j);
/*     */       }
/*     */     } 
/* 198 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private COORDINATE clean(Tile j) {
/* 208 */     return (COORDINATE)j.coo;
/*     */   }
/*     */   
/*     */   public void reportSkill(RoomInstance inss, Humanoid h) {
/* 212 */     HunterInstance ins = (HunterInstance)inss;
/* 213 */     ins.dSkill += IndustryUtil.roomBonus(ins, (IndustryRate)this.indus.get(0)) * this.bonus.get((BOOSTABLE_O)h.indu());
/* 214 */     ins.iSkill++;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean work(RoomInstance inss, COORDINATE work, Humanoid h, boolean cadaver) {
/* 219 */     HunterInstance ins = (HunterInstance)this.getter.get(work);
/* 220 */     if (ins == null) {
/* 221 */       return false;
/*     */     }
/*     */     
/* 224 */     if (ins.produce > 1.0F) {
/* 225 */       double mm = (1.0F + ins.produce / 10.0F);
/* 226 */       mm = CLAMP.d(mm, 0.0D, ins.produce);
/* 227 */       ins.produce = (float)(ins.produce - mm);
/* 228 */       DIR dir = storeDir(work);
/* 229 */       for (IndustryResource o : ins.industry().outs()) {
/* 230 */         int am = o.inc((ROOM_IDATA_INSTANCE)ins, mm * o.rate);
/* 231 */         if (am > 0) {
/* 232 */           (SETT.THINGS()).resources.createPrecise(work.x() + dir.x(), work.y() + dir.y(), ((IndustryResource)ins.industry().outs().get(0)).resource, am);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 239 */     Tile j = this.tile.init(work.x(), work.y(), ins);
/* 240 */     j.cadaver.set((ROOMA)ins, cadaver ? 1 : 0);
/*     */     
/* 242 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void workFinish(COORDINATE work) {
/* 248 */     HunterInstance ins = (HunterInstance)this.getter.get(work);
/* 249 */     if (ins == null) {
/*     */       return;
/*     */     }
/* 252 */     Tile j = this.tile.init(work.x(), work.y(), ins);
/* 253 */     if (j != null) {
/* 254 */       j.cadaver.set((ROOMA)ins, 0);
/* 255 */       j.reserved.set((ROOMA)ins, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DIR storeDir(COORDINATE c) {
/* 263 */     for (DIR d : DIR.ORTHO) {
/* 264 */       if ((SETT.ROOMS()).fData.tile.get(c, d) == this.constructor.rr)
/* 265 */         return d; 
/*     */     } 
/* 267 */     return DIR.C;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\ROOM_HUNTER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */