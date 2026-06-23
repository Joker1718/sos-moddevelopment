/*      */ package settlement.tilemap.terrain;
/*      */ 
/*      */ import settlement.main.SETT;
/*      */ import settlement.path.AVAILABILITY;
/*      */ import settlement.room.main.Room;
/*      */ import settlement.thing.pointlight.LOS;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.color.COLOR;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.sprite.TILE_SHEET;
/*      */ import util.rendering.RenderData;
/*      */ import util.rendering.ShadowBatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Ceiling
/*      */   extends TBuilding.BuildingComponent
/*      */ {
/*      */   private static final int SET = 16;
/*      */   private final TILE_SHEET sheet;
/*      */   private final int SHEET_CORNER;
/*      */   private final int SHEET_SHADOW;
/*      */   private final Opening opening;
/*      */   
/*      */   private Ceiling(String key, Terrain t) {
/*  806 */     super(key + "_CEILING", t, paramTBuilding.structure.nameCeiling, paramTBuilding.iconCeiling, paramTBuilding.structure.miniColor, paramTBuilding.structure.resource);
/*  807 */     this.sheet = paramTBuilding.spriteCeiling;
/*  808 */     this.SHEET_CORNER = 64;
/*  809 */     this.SHEET_SHADOW = this.SHEET_CORNER + 16;
/*  810 */     this.opening = new Opening(key, t);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean place(int x, int y) {
/*  816 */     if (this.opening.isPlacable(x, y)) {
/*  817 */       return this.opening.place(x, y);
/*      */     }
/*  819 */     boolean was = (this.shared.get(x, y) == this);
/*  820 */     placeRaw(x, y);
/*  821 */     int data = 0;
/*  822 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  823 */       DIR d = (DIR)DIR.ORTHO.get(i);
/*  824 */       if (joins(x, y, d)) {
/*  825 */         data |= d.mask();
/*      */       }
/*      */     } 
/*      */     
/*  829 */     data = setCorners(x, y, data);
/*  830 */     data = shadowSet(x, y, data);
/*      */     
/*  832 */     this.shared.data.set(x, y, data);
/*  833 */     if (!(SETT.ROOMS()).map.is(x, y) && !was)
/*  834 */       (SETT.FLOOR()).clearer.clear(x, y); 
/*  835 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private int setCorners(int x, int y, int res) {
/*  840 */     int corner = 0;
/*  841 */     for (int i = 0; i < DIR.NORTHO.size(); i++) {
/*  842 */       DIR d = (DIR)DIR.NORTHO.get(i);
/*  843 */       if (joins(x, y, d) && !joins(x, y, d.next(-1)) && !joins(x, y, d.next(1))) {
/*  844 */         corner |= d.mask();
/*      */       }
/*      */     } 
/*  847 */     res |= corner << 4;
/*  848 */     return res;
/*      */   }
/*      */   
/*      */   private int shadowSet(int x, int y, int res) {
/*  852 */     int s = 0;
/*  853 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  854 */       if (TBuilding.jwall.is(x, y, (DIR)DIR.ORTHO.get(i))) {
/*  855 */         s |= ((DIR)DIR.ORTHO.get(i)).mask();
/*      */       }
/*      */     } 
/*  858 */     res |= s << 8;
/*      */     
/*  860 */     return res;
/*      */   }
/*      */   
/*      */   private int shadowGet(int data) {
/*  864 */     return data >> 8 & 0xF;
/*      */   }
/*      */   
/*      */   private int getCorners(int data) {
/*  868 */     return data >> 4 & 0xF;
/*      */   }
/*      */   
/*      */   private int getData(int data, RenderData.RenderIterator i) {
/*  872 */     int res = data & 0xF;
/*  873 */     Room r = (SETT.ROOMS()).map.get(i.tx(), i.ty());
/*  874 */     if (r != null && r.constructor() != null && r.constructor().mustBeIndoors()) {
/*  875 */       for (DIR d : DIR.ORTHO) {
/*  876 */         if (!r.isSame(i.tx(), i.ty(), i.tx() + d.x(), i.ty() + d.y()) && 
/*  877 */           !(SETT.TERRAIN().get(i.tx() + d.x(), i.ty() + d.y()) instanceof Opening)) {
/*  878 */           res |= d.mask();
/*      */         }
/*      */       } 
/*      */     } else {
/*  882 */       for (DIR d : DIR.ORTHO) {
/*  883 */         r = (Room)(SETT.ROOMS()).map.get(i.tx(), i.ty(), d);
/*  884 */         if (r != null && r.constructor() != null && r.constructor().mustBeIndoors()) {
/*  885 */           res |= d.mask();
/*      */         }
/*      */       } 
/*      */     } 
/*  889 */     return res;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  902 */     int a = getData(data, i);
/*  903 */     if (a != 0) {
/*  904 */       int j = a + (i.ran() & 0x3) * 16;
/*  905 */       this.sheet.render(r, j, i.x(), i.y());
/*      */     } 
/*      */     
/*  908 */     a = getCorners(data);
/*  909 */     if (a != 0) {
/*  910 */       this.sheet.render(r, this.SHEET_CORNER + a, i.x(), i.y());
/*      */     }
/*      */     
/*  913 */     a = shadowGet(data);
/*      */ 
/*      */     
/*  916 */     s.setDistance2Ground(0.0D).setHeight(2);
/*  917 */     this.sheet.render((SPRITE_RENDERER)s, this.SHEET_SHADOW, i.x(), i.y());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  929 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  934 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public AVAILABILITY getAvailability(int x, int y) {
/*  939 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPlacable(int tx, int ty) {
/*  948 */     return true;
/*      */   }
/*      */   
/*      */   private boolean joins(int x, int y, DIR d) {
/*  952 */     return ((Terrain.TerrainTile)this.shared.get(x, y, d)).wallIsWally();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean is(int tx, int ty) {
/*  957 */     return !(!super.is(tx, ty) && !this.opening.is(tx, ty));
/*      */   }
/*      */ 
/*      */   
/*      */   boolean wallJoiner() {
/*  962 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean wallIsWally() {
/*  967 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean roofIs() {
/*  972 */     return true;
/*      */   }
/*      */   
/*      */   public class Opening
/*      */     extends TBuilding.BuildingComponent implements TerrainDiagonal.Diagonalizer {
/*      */     private static final int SET = 16;
/*      */     private final TILE_SHEET sheet;
/*      */     private final TILE_SHEET shadow;
/*  980 */     private final int CORNERS = 64;
/*  981 */     private final int SINGLES = 128;
/*  982 */     private final int DIA = 4096;
/*  983 */     private final int FAT = 8192;
/*      */     
/*      */     private Opening(String key, Terrain t) {
/*  986 */       super(key + "_OPENING", t, (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.nameCeiling, (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).iconCeiling, (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.miniColor, (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.resource);
/*  987 */       this.sheet = (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).spriteOpening;
/*  988 */       this.shadow = (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).spriteWall;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean place(int x, int y) {
/*  993 */       if (!isPlacable(x, y)) {
/*  994 */         return TBuilding.Ceiling.this.place(x, y);
/*      */       }
/*      */       
/*  997 */       boolean dia = (this.shared.get(x, y) instanceof TerrainDiagonal.Diagonalizer && ((TerrainDiagonal.Diagonalizer)this.shared.get(x, y)).getDia(x, y));
/*  998 */       placeRaw(x, y);
/*      */       
/* 1000 */       int res = 0;
/*      */       
/* 1002 */       if (isFat(x, y)) {
/* 1003 */         res |= 0x2000;
/* 1004 */         for (DIR d : DIR.ORTHO) {
/* 1005 */           if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/* 1006 */             res |= d.mask() | d.next(2).mask(); 
/*      */         } 
/*      */       } else {
/* 1009 */         for (DIR d : DIR.ORTHO) {
/* 1010 */           if (!isFat(x + d.x(), y + d.y()) && joins(x, y, d)) {
/* 1011 */             res |= d.mask();
/*      */           }
/*      */         } 
/*      */       } 
/* 1015 */       int cor = 0;
/* 1016 */       for (DIR d : DIR.NORTHO) {
/* 1017 */         if (!joins(x, y, d) && (res & d.next(1).mask()) != 0 && (res & d.next(-1).mask()) != 0)
/* 1018 */           cor |= d.mask(); 
/*      */       } 
/* 1020 */       res |= cor << 8;
/*      */       
/* 1022 */       if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.N)) {
/* 1023 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.N);
/* 1024 */         if (t != this && t != (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall && t.wallIsWally() && !t.roofIs()) {
/* 1025 */           if ((res & DIR.NW.mask()) != 0)
/* 1026 */             res |= 0x20; 
/* 1027 */           if ((res & DIR.NE.mask()) != 0)
/* 1028 */             res |= 0x10; 
/*      */         } 
/*      */       } 
/* 1031 */       if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.W)) {
/* 1032 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.W);
/* 1033 */         if (t != this && t != (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall && t.wallIsWally() && !t.roofIs()) {
/* 1034 */           if ((res & DIR.SW.mask()) != 0)
/* 1035 */             res |= 0x80; 
/* 1036 */           if ((res & DIR.NW.mask()) != 0) {
/* 1037 */             res |= 0x40;
/*      */           }
/*      */         } 
/*      */       } 
/* 1041 */       this.shared.data.set(x, y, res);
/* 1042 */       setDia(x, y, dia);
/* 1043 */       return false;
/*      */     }
/*      */     
/*      */     private boolean isFat(int x, int y) {
/* 1047 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 1048 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 1049 */         if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/* 1050 */           return true; 
/*      */       } 
/* 1052 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 1059 */       int tile = data & 0xF;
/* 1060 */       int cor = data >> 8 & 0xF;
/* 1061 */       (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.tint.color.bind();
/* 1062 */       if (tile == 0) {
/*      */ 
/*      */         
/* 1065 */         this.sheet.render(r, 128 + (i.ran() & 0xF), i.x(), i.y());
/* 1066 */         s.setHeight(3).setDistance2Ground(0.0D);
/* 1067 */         (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, 256, i.x(), i.y());
/*      */       }
/*      */       else {
/*      */         
/* 1071 */         int j = tile + (i.ran() & 0x1) * 16;
/* 1072 */         if (tile != 15 && (data & 0x1000) != 0)
/* 1073 */           j += 32; 
/* 1074 */         if (tile != 15)
/* 1075 */           this.sheet.render(r, j, i.x(), i.y()); 
/* 1076 */         s.setHeight(12).setDistance2Ground(0.0D);
/* 1077 */         if (tile == 15) {
/* 1078 */           (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, 272, i.x(), i.y());
/*      */         } else {
/* 1080 */           (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, tile + (((data & 0x1000) != 0) ? 64 : 0), i.x(), i.y());
/*      */         } 
/* 1082 */         if (cor != 0) {
/* 1083 */           int c = cor + 64 + (((data & 0x2000) != 0) ? 16 : 0);
/* 1084 */           this.sheet.render(r, c + (((data & 0x1000) != 0) ? 32 : 0), i.x(), i.y());
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1092 */       COLOR.unbind();
/*      */       
/* 1094 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean joins(int tx, int ty, DIR d) {
/* 1099 */       return TBuilding.jwall.is(tx, ty, d);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 1105 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public AVAILABILITY getAvailability(int x, int y) {
/* 1110 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isPlacable(int tx, int ty) {
/* 1116 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 1117 */         DIR d = (DIR)DIR.ALL.get(i);
/* 1118 */         if (!TBuilding.jwall.is(tx, ty, d)) {
/* 1119 */           return true;
/*      */         }
/*      */       } 
/*      */       
/* 1123 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean wallJoiner() {
/* 1128 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean wallIsWally() {
/* 1133 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean roofIs() {
/* 1138 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setDia(int x, int y, boolean dia) {
/* 1143 */       if (!is(x, y))
/*      */         return; 
/* 1145 */       int data = this.shared.data.get(x, y);
/* 1146 */       if (dia) {
/* 1147 */         data |= 0x1000;
/*      */       } else {
/* 1149 */         data &= 0xFFFFEFFF;
/* 1150 */       }  this.shared.data.set(x, y, data);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean getDia(int tx, int ty) {
/* 1155 */       if (!is(tx, ty))
/* 1156 */         return false; 
/* 1157 */       return ((this.shared.data.get(tx, ty) & 0x1000) != 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public int heightStart(int tx, int ty) {
/* 1162 */       return 3;
/*      */     }
/*      */ 
/*      */     
/*      */     public int heightEnd(int tx, int ty) {
/* 1167 */       return 5;
/*      */     }
/*      */ 
/*      */     
/*      */     public LOS los(int tx, int ty) {
/* 1172 */       return LOS.CEILING;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void unplace(int tx, int ty) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean wantsFloorUnderneath(int tx, int ty) {
/* 1183 */       return false;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int heightStart(int tx, int ty) {
/* 1190 */     return 3;
/*      */   }
/*      */ 
/*      */   
/*      */   public int heightEnd(int tx, int ty) {
/* 1195 */     return 5;
/*      */   }
/*      */ 
/*      */   
/*      */   public LOS los(int tx, int ty) {
/* 1200 */     return LOS.CEILING;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBuilding$Ceiling.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */