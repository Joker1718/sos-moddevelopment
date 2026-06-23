/*     */ package settlement.room.main.throne;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import view.tool.PLACABLE;
/*     */ 
/*     */ public class THRONE
/*     */   extends RoomBlueprint {
/*  26 */   private final Coo instance = new Coo((SETT.TWIDTH / 2), (SETT.THEIGHT / 2));
/*  27 */   private int tile = this.instance.x() + this.instance.y() * SETT.TWIDTH;
/*  28 */   final Coo construction = new Coo(-1.0D, -1.0D);
/*     */   
/*     */   final Sprite sprite;
/*     */   public final INFO info;
/*     */   public final PLACABLE placer;
/*     */   public final Initer init;
/*     */   
/*     */   public THRONE(RoomInitData init, RoomCategorySub cat) throws IOException {
/*  36 */     super("_THRONE");
/*  37 */     init.init("_THRONE");
/*  38 */     this.info = new INFO(init.text());
/*  39 */     this.sprite = new Sprite(init);
/*     */     
/*  41 */     this.init = new Initer(this);
/*  42 */     this.placer = (PLACABLE)new Placer(this);
/*  43 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int tile() {
/*  51 */     return (SETT.ROOMS()).THRONE.tile;
/*     */   }
/*     */   
/*     */   public static COORDINATE coo() {
/*  55 */     return (COORDINATE)(SETT.ROOMS()).THRONE.instance;
/*     */   }
/*     */   
/*     */   public static DIR rot() {
/*  59 */     Room r = (Room)(SETT.ROOMS()).map.get(coo());
/*  60 */     if (r != null && r instanceof Instance) {
/*  61 */       return (DIR)DIR.ORTHO.get(((Instance)r).rot);
/*     */     }
/*  63 */     return DIR.N;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room get(int tx, int ty) {
/*  68 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  69 */     if (r != null && r instanceof Instance)
/*  70 */       return r; 
/*  71 */     return null;
/*     */   }
/*     */   
/*     */   void setInstance(int tx, int ty) {
/*  75 */     this.instance.set(tx, ty);
/*  76 */     this.tile = this.instance.x() + this.instance.y() * SETT.TWIDTH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniC(int tx, int ty) {
/*  92 */     return this.sprite.miniC;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COLOR miniCPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern) {
/*  98 */     return (COLOR)origional;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/* 103 */     this.instance.save(saveFile);
/* 104 */     this.construction.save(saveFile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/* 110 */     this.instance.load(saveFile);
/* 111 */     this.construction.load(saveFile);
/* 112 */     this.tile = this.instance.x() + this.instance.y() * SETT.TWIDTH;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 117 */     setInstance(SETT.TWIDTH / 2, SETT.THEIGHT / 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/* 129 */     return (SPRITE)this.sprite.icon;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\throne\THRONE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */