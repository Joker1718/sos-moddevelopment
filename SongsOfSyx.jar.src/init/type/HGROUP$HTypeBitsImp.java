/*     */ package init.type;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HTypeBitsImp
/*     */   implements HGROUP.HTypeBits, Serializable
/*     */ {
/*     */   private static HTypeBitsImp[] specific;
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int[] data;
/*     */   
/*     */   public static HGROUP.HTypeBits specific(HGROUP t) {
/* 144 */     if (specific == null) {
/* 145 */       specific = new HTypeBitsImp[HGROUP.all().size()];
/* 146 */       for (int i = 0; i < HGROUP.all().size(); i++) {
/* 147 */         specific[i] = new HTypeBitsImp(false);
/* 148 */         specific[i].set((HGROUP)HGROUP.all().get(i));
/*     */       } 
/*     */     } 
/* 151 */     return specific[t.index];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HTypeBitsImp(boolean everyone) {
/* 162 */     if (everyone)
/* 163 */       setEveryone(); 
/*     */   }
/*     */   
/*     */   private int[] bits() {
/* 167 */     if (this.data == null) {
/* 168 */       this.data = Alloc.ii((int)Math.ceil(HGROUP.all().size() / 32.0D));
/* 169 */     } else if (this.data.length != Math.ceil(HGROUP.all().size() / 32.0D)) {
/* 170 */       this.data = Alloc.ii((int)Math.ceil(HGROUP.all().size() / 32.0D));
/*     */     } 
/* 172 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int index) {
/* 177 */     int ii = index >>> 5;
/* 178 */     int m = 1 << (index & 0x1F);
/* 179 */     return ((bits()[ii] & m) != 0);
/*     */   }
/*     */   
/*     */   public HTypeBitsImp set(HGROUP type) {
/* 183 */     int index = type.index;
/* 184 */     int ii = index >>> 5;
/* 185 */     int m = 1 << (index & 0x1F);
/* 186 */     bits()[ii] = bits()[ii] | m;
/*     */     
/* 188 */     return this;
/*     */   }
/*     */   
/*     */   public HTypeBitsImp copy(HGROUP.HTypeBits other) {
/* 192 */     clear();
/* 193 */     for (int i = 0; i < HGROUP.all().size(); i++) {
/* 194 */       if (other.is(i))
/* 195 */         set((HGROUP)HGROUP.all().get(i)); 
/*     */     } 
/* 197 */     return this;
/*     */   }
/*     */   
/*     */   public HTypeBitsImp setEveryone() {
/* 201 */     int[] bits = bits();
/* 202 */     for (int i = 0; i < bits.length; i++) {
/* 203 */       bits[i] = -1;
/*     */     }
/* 205 */     return this;
/*     */   }
/*     */   
/*     */   public HTypeBitsImp clear(HGROUP type) {
/* 209 */     int index = type.index;
/* 210 */     int ii = index >>> 5;
/* 211 */     int m = 1 << (index & 0x1F);
/* 212 */     bits()[ii] = bits()[ii] & (m ^ 0xFFFFFFFF);
/* 213 */     return this;
/*     */   }
/*     */   
/*     */   public HTypeBitsImp clear() {
/* 217 */     int[] bits = bits();
/* 218 */     for (int i = 0; i < bits.length; i++) {
/* 219 */       bits[i] = 0;
/*     */     }
/* 221 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HGROUP$HTypeBitsImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */